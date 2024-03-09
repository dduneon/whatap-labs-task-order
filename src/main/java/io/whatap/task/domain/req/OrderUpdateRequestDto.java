package io.whatap.task.domain.req;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 07
 */
@NoArgsConstructor
@Getter
public class OrderUpdateRequestDto {
    @NotBlank(message = "orderId 필드가 비어 있습니다")
    private Long orderId;
    @NotBlank(message = "productId 필드가 비어 있습니다")
    private Long productId;
}
