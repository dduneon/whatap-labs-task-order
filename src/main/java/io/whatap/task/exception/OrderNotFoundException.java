package io.whatap.task.exception;

/**
 * 주문이 존재하지 않을 때 발생하는 Exception 클래스
 *
 * @author 김준현
 * @version 2024. 03. 08
 */
public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(Long orderId) {
        super(String.format("Order(id=%d) 를 찾을 수 없습니다", orderId));
    }
}
