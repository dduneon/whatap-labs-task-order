package io.whatap.task.order.service;

import io.quarkus.panache.common.Sort;
import io.whatap.task.client.ProductAdaptor;
import io.whatap.task.client.ProductResponseDto;
import io.whatap.task.exception.OrderNotFoundException;
import io.whatap.task.exception.ProductNotExistException;
import io.whatap.task.order.domain.req.OrderCreateRequestDto;
import io.whatap.task.order.domain.req.OrderUpdateRequestDto;
import io.whatap.task.order.domain.res.OrderAllResponseDto;
import io.whatap.task.order.domain.res.OrderDetailResponseDto;
import io.whatap.task.order.domain.res.OrderResponseDto;
import io.whatap.task.order.entity.Order;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.resteasy.reactive.ClientWebApplicationException;

/**
 * 주문에 관한 CRUD 를 제공하는 서비스 클래스
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
    public OrderAllResponseDto readAllOrders() {
        List<Order> orderEntityList = Order.listAll(Sort.by("id"));
        List<OrderResponseDto> orderList = orderEntityList.stream().map(OrderResponseDto::toDto).toList();
        return new OrderAllResponseDto(orderList.size(), orderList);
    }

    @Transactional
    public OrderDetailResponseDto readDetailByOrderId(Long orderId) {
        Order order = Order.findById(orderId);
        if (Objects.isNull(order)) {
            throw new OrderNotFoundException(orderId);
        }
        try {
            ProductResponseDto product = productAdaptor.getProductById(order.getProductId());
            return new OrderDetailResponseDto(orderId, product);
        } catch (ClientWebApplicationException e) {
            if (e.getResponse().getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
                throw new ProductNotExistException(order.getProductId());
            }
        }
        throw new RuntimeException("서버 연결 오류");
    }

    @Transactional
    public void createOrder(OrderCreateRequestDto orderCreateRequestDto) {
        Long productId = orderCreateRequestDto.getProductId();
        if (!isExistProduct(productId)) {
            throw new ProductNotExistException(productId);
        }
        Order order = Order.builder()
                .productId(productId)
                .build();

        order.persist();
    }

    @Transactional
    public void updateOrder(OrderUpdateRequestDto orderUpdateRequestDto) {
        Long productId = orderUpdateRequestDto.getProductId();
        if (!isExistProduct(productId)) {
            throw new ProductNotExistException(productId);
        }
        Order order = Order.findById(orderUpdateRequestDto.getOrderId());
        if (Objects.isNull(order)) {
            throw new OrderNotFoundException(orderUpdateRequestDto.getOrderId());
        }
        order.updateProduct(productId);
    }

    @Transactional
    public void deleteOrder(Long orderId) {
        if (!Order.deleteById(orderId)) {
            throw new OrderNotFoundException(orderId);
        }
    }

    /**
     * 상품이 존재하는 지 판단하는 메서드
     *
     * @param productId 판단할 상품 아이디
     * @return 상품이 존재하면 true, 존재하지 않으면 false
     */
    private boolean isExistProduct(Long productId) {
        try {
            ProductResponseDto product = productAdaptor.getProductById(productId);
            if (Objects.nonNull(product)) {
                return true;
            }
        } catch (WebApplicationException e) {
            if (e.getResponse().getStatus() == Response.Status.NOT_FOUND.getStatusCode()) {
                return false;
            }
        }
        return false;
    }
}
