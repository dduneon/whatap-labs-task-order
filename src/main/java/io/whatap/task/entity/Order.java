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
 * description
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

    public void updateProduct(Long productId) {
        this.productId = productId;
    }
}
