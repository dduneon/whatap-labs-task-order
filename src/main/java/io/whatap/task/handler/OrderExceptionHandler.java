package io.whatap.task.handler;

import io.whatap.task.exception.OrderNotFoundException;
import io.whatap.task.exception.ProductNotExistException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import java.util.Map;

/**
 * description
 *
 * @author 김준현
 * @version 2024. 03. 09
 */
@Provider
public class OrderExceptionHandler implements ExceptionMapper<Exception> {
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
