package io.whatap.task.order.domain.res;

import io.whatap.task.client.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 특정 주문의 상세정보를 응답하는 Dto 클래스
 *
 * @author 김준현
 * @version 2024. 03. 08
 */

@AllArgsConstructor
@Getter
public class OrderDetailResponseDto {
    private Long orderId;
    private ProductResponseDto productDetail;
}
