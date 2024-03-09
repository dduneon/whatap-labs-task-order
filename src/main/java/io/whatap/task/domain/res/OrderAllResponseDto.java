package io.whatap.task.domain.res;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 모든 주문 리스트를 응답하는 Dto 클래스
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
