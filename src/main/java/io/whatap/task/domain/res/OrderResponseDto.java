package io.whatap.task.domain.res;

import io.whatap.task.entity.Order;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description
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
