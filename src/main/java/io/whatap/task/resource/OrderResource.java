package io.whatap.task.resource;

import io.whatap.task.service.OrderService;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 07
 */

@Path("/order")
public class OrderResource {
    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    @GET
    public Response getOrders() {
        return Response.ok().build();
    }
}
