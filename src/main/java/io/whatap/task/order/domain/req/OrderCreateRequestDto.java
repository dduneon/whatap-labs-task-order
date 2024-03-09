package io.whatap.task.order.domain.req;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 상품 생성 요청 Dto 클래스
 *
 * @author 김준현
 * @version 2024. 03. 07
 */
@NoArgsConstructor
@Getter
public class OrderCreateRequestDto {
    @NotNull(message = "productId 필드가 비어 있습니다")
    private Long productId;
}
