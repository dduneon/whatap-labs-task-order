package io.whatap.task.exception;

/**
 * 상품이 존재하지 않을 때 발생하는 Exception 클래스
 *
 * @author 김준현
 * @version 2024. 03. 08
 */
public class ProductNotExistException extends RuntimeException {
    public ProductNotExistException(Long productId) {
        super(String.format("Product(id=%d) 를 찾을 수 없습니다", productId));
    }
}
