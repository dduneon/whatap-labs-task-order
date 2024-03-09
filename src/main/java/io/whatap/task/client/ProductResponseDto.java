package io.whatap.task.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 상품 요청에 대한 응답 Dto 클래스
 *
 * @author : dduneon
 * @version : 2024. 03. 07
 */
@Getter
@AllArgsConstructor
public class ProductResponseDto {
    private Long id;
    private String name;
    private String description;
}
