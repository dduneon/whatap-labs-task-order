package io.whatap.task.exception;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 08
 */
public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(Long orderId) {
        super(String.format("Order(id=%d) 를 찾을 수 없습니다", orderId));
    }
}
