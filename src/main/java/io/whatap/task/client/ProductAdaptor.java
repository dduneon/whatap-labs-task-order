package io.whatap.task.client;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

/**
 * Product API 요청을 보내는 Product Adaptor 클래스
 *
 * @author : dduneon
 * @version : 2024. 03. 07
 */

@Path("/api/products")
@RegisterRestClient
public interface ProductAdaptor {
    /**
     * 상품 ID로 Product Rest API 요청을 보내 상품 상세 정보를 가져오는 메서드
     *
     * @param productId 상품의 ID
     * @return 상품 상세 정보
     */
    @GET
    @Path("/{productId}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductResponseDto getProductById(@PathParam("productId") Long productId);
}
