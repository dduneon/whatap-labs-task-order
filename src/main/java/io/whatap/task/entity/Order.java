package io.whatap.task.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * 주문 테이블 엔티티 클래스
 *
 * @author 김준현
 * @version 2024. 03. 07
 */
@Entity
@Table(name = "Orders")
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends PanacheEntity {
    @Column(name = "product_id")
    private Long productId;

    /**
     * 특정 주문의 상품을 변경하는 메서드
     *
     * @param productId 변경할 상품의 ID
     */
    public void updateProduct(Long productId) {
        this.productId = productId;
    }
}
