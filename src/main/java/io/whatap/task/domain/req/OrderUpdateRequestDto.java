package io.whatap.task.domain.req;

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
    private Long orderId;
    private Long productId;
}
