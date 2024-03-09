package io.whatap.task.resource;

import io.whatap.task.domain.req.OrderCreateRequestDto;
import io.whatap.task.domain.req.OrderUpdateRequestDto;
import io.whatap.task.service.OrderService;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * 주문 Rest API 요청을 받고, 적절한 응답을 생성하는 Resource 클래스
 *
 * @author 김준현
 * @version 2024. 03. 07
 */

@Slf4j
@Path("/api/orders")
@Produces(MediaType.APPLICATION_JSON)
public class OrderResource {
    private final OrderService orderService;

    public OrderResource(OrderService orderService) {
        this.orderService = orderService;
    }

    /**
     * 모든 주문 목록에 대한 정보를 가져오는 요청을 받는 메서드
     *
     * @return 주문 테이블에 존재하는 모든 주문 리스트 및 개수, 정상 응답시 OK
     */
    @GET
    public Response getOrders() {
        return Response.ok(orderService.readAllOrders()).build();
    }

    /**
     * 특정 주문을 조회하는 요청을 받는 메서드
     *
     * @param orderId 조회할 주문의 아이디
     * @return 해당 주문에 대한 정보, 정상 응답시 OK
     */
    @GET
    @Path("/{orderId}")
    public Response getOrder(@PathParam("orderId") Long orderId) {
        return Response.ok(orderService.readDetailByOrderId(orderId)).build();
    }

    /**
     * 특정 상품을 주문하는 요청을 받는 메서드
     *
     * @param orderCreateRequestDto 주문할 상품의 아이디를 담은 Dto 클래스
     * @return 주문 생성시 CREATED, 존재하지 않는 상품일 시 NOT_FOUND
     */
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response orderProduct(@Valid OrderCreateRequestDto orderCreateRequestDto) {
        orderService.createOrder(orderCreateRequestDto);
        return Response.status(Response.Status.CREATED).build();
    }

    /**
     * 주문에 해당하는 상품을 변경하는 요청을 받는 메서드
     *
     * @param orderUpdateRequestDto 주문 ID와 상품 ID를 담은 Dto 클래스
     * @return 변경 완료시 NO_CONTENTS, 주문이 존재하지 않거나 상품이 존재하지 않을 시 NOT_FOUND
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public Response changeProduct(@Valid OrderUpdateRequestDto orderUpdateRequestDto) {
        orderService.updateOrder(orderUpdateRequestDto);
        return Response.status(Response.Status.NO_CONTENT).build();
    }

    /**
     * 특정 주문을 삭제하는 요청을 받는 메서드
     *
     * @param orderId 삭제할 주문의 ID
     * @return 삭제 완료시 NO_CONTENTS, 주문이 존재하지 않는 경우 NOT_FOUND
     */
    @DELETE
    @Path("/{orderId}")
    public Response deleteOrder(@PathParam("orderId") Long orderId) {
        orderService.deleteOrder(orderId);
        return Response.status(Response.Status.NO_CONTENT).build();
    }
}
