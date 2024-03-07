package io.whatap.task.adaptor;

import io.whatap.task.domain.ProductResponseDto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * description:
 *
 * @author : dduneon
 * @version : 2024. 03. 07
 */

@Path("/api/product")
@RegisterRestClient
public interface ProductService {
    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductResponseDto getProductById(@PathParam("productId") Long productId);
}
