package io.whatap.task.service;

import io.quarkus.panache.common.Sort;
import io.whatap.task.client.ProductAdaptor;
import io.whatap.task.client.ProductResponseDto;
import io.whatap.task.domain.res.OrderDetailResponseDto;
import io.whatap.task.entity.Order;
import io.whatap.task.exception.OrderNotFoundException;
import io.whatap.task.exception.ProductNotExistException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 07
 */
@Slf4j
@ApplicationScoped
public class OrderService {
    private final ProductAdaptor productAdaptor;

    public OrderService(@RestClient ProductAdaptor productAdaptor) {
        this.productAdaptor = productAdaptor;
    }

    @Transactional
    public List<Order> readAllOrders() {
        List<Order> orders = Order.listAll(Sort.by("id"));
        return orders;
    }

    @Transactional
    public OrderDetailResponseDto readDetailByOrderId(Long orderId) {
        Order order = Order.findById(orderId);
        if(Objects.isNull(order)) {
            throw new OrderNotFoundException(orderId);
        }
        try {
            ProductResponseDto product = productAdaptor.getProductById(order.getProductId());
            return new OrderDetailResponseDto(orderId, product);
        } catch (WebApplicationException e) {
            // todo error
            if(e.getResponse().getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
                log.info(e.getMessage());
            } else {

            }
        }
        // todo error
        throw new RuntimeException();
    }

    @Transactional
    public void createOrder(Long productId) {
        ProductResponseDto product = productAdaptor.getProductById(productId);
        if(Objects.isNull(product)) {
            throw new ProductNotExistException(productId);
        }
        Order order = Order.builder()
                .productId(productId)
                .build();

        order.persist();
    }

    @Transactional
    public void updateOrder() {

    }
}
