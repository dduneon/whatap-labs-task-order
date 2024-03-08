package io.whatap.task.resource;

import io.whatap.task.domain.req.OrderCreateRequestDto;
import io.whatap.task.domain.req.OrderUpdateRequestDto;
import io.whatap.task.service.OrderService;
import jakarta.validation.Valid;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
        return Response.ok(orderService.readDetailByOrderId(orderId)).build();
    }

    @POST
    public Response orderProduct(@Valid OrderCreateRequestDto orderCreateRequestDto) {
        orderService.createOrder(orderCreateRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    public Response changeProduct(@Valid OrderUpdateRequestDto orderUpdateRequestDto) {
        orderService.updateOrder(orderUpdateRequestDto);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    @DELETE
    @Path("/{orderId}")
    public Response deleteOrder(@PathParam("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
