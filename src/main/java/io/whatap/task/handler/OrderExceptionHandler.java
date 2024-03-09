package io.whatap.task.handler;

import io.whatap.task.exception.OrderNotFoundException;
import io.whatap.task.exception.ProductNotExistException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;

/**
 * Order 에서 발생하는 예외를 처리하는 Exception Handler 클래스
 *
 * @author 김준현
 * @version 2024. 03. 09
 */
@Provider
public class OrderExceptionHandler implements ExceptionMapper<Exception> {
    /**
     * Exception 이 발생했을 때, Exception Type 에 따른 응답을 리턴하는 메서드
     *
     * @param exception 발생한 Exception 객체
     * @return Exception 에 따른 적절한 응답
     */
    @Override
    public Response toResponse(Exception exception) {
        if (exception instanceof OrderNotFoundException || exception instanceof ProductNotExistException) {
            return handleNotFoundException(exception);
        } else {
            return handleGenericException(exception);
        }
    }

    private Response handleNotFoundException(Exception exception) {
        return Response.status(Response.Status.NOT_FOUND)
                .entity(Map.of("status", Response.Status.NOT_FOUND.getStatusCode(), "message", exception.getMessage()))
                .build();
    }

    private Response handleGenericException(Exception exception) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity(Map.of("status", Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(), "message",
                        exception.getMessage()))
                .build();
    }
}
