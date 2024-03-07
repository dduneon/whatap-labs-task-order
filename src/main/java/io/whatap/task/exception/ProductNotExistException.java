package io.whatap.task.exception;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 08
 */
public class ProductNotExistException extends RuntimeException{
    public ProductNotExistException(Long productId) {
        super(String.format("Product(id=%d) 를 찾을 수 없습니다", productId));
    }
}
