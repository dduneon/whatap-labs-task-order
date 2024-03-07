package io.whatap.task.domain.res;

import io.whatap.task.client.ProductResponseDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 08
 */

@AllArgsConstructor
@Getter
public class OrderDetailResponseDto {
    private Long orderId;
    private ProductResponseDto productResponseDto;
}
