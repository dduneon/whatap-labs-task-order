package io.whatap.task.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * description:
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
