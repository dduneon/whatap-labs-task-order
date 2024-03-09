package io.whatap.task.domain.res;

import io.whatap.task.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 특정 주문의 ID 와 해당하는 상품의 ID를 응답하는 Dto 클래스
 *
 * @author 김준현
 * @version 2024. 03. 07
 */
@AllArgsConstructor
@Getter
public class OrderResponseDto {
    private Long orderId;
    private Long productId;

    public static OrderResponseDto toDto(Order order) {
        return new OrderResponseDto(order.id, order.getProductId());
    }
}
