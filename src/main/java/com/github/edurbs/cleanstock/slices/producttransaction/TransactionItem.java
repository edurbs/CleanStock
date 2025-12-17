package com.github.edurbs.cleanstock.slices.producttransaction;

import com.github.edurbs.cleanstock.slices.product.Product;
import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

@JmixEntity
@Table(name = "MOVEMENT_ITEM", indexes = {
        @Index(name = "IDX_MOVEMENT_ITEM_PRODUCT_MOVEMENT", columnList = "PRODUCT_MOVEMENT_ID"),
        @Index(name = "IDX_MOVEMENT_ITEM_PRODUCT", columnList = "PRODUCT_ID")
})
@Entity
public class TransactionItem {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID")
    private Product product;

    @Column(name = "QUANTITY", precision = 19, scale = 2)
    private BigDecimal quantity;

    @Column(name = "UNIT_PRICE", precision = 19, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "TOTAL_PRICE", precision = 19, scale = 2)
    private BigDecimal totalPrice;

    @Column(name = "PRICE_TYPE", nullable = false)
    @NotNull
    private String priceType;

    @JoinColumn(name = "PRODUCT_MOVEMENT_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private ProductTransaction productMovement;

    public PriceType getPriceType() {
        return priceType == null ? null : PriceType.fromId(priceType);
    }

    public void setPriceType(PriceType priceType) {
        this.priceType = priceType == null ? null : priceType.getId();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ProductTransaction getProductMovement() {
        return productMovement;
    }

    public void setProductMovement(ProductTransaction productMovement) {
        this.productMovement = productMovement;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}