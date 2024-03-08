package io.whatap.task.domain.res;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 09
 */
@Getter
@AllArgsConstructor
public class OrderAllResponseDto {
    private long count;
    private List<OrderResponseDto> orders;
}
