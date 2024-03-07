package io.whatap.task.resource;

import io.whatap.task.service.OrderService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 07
 */

@Slf4j
@Path("/api/orders")
public class OrderResource {
    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GET
    public Response getOrders() {
        return Response.ok(orderService.readAllOrders()).build();
    }

    @GET
    @Path("/{orderId}")
    public Response getOrder(@PathParam("orderId") Long orderId) {
        return Response.ok(orderService.readAllOrders()).build();
    }
}
