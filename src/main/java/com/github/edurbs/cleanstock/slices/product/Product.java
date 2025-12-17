package com.github.edurbs.cleanstock.slices.product;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@JmixEntity
@Table(name = "PRODUCT")
@Entity
public class Product {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "DESCRIPTION")
    private String description;

    @NumberFormat(pattern = "#,##0.000", decimalSeparator = ",", groupingSeparator = ".")
    @Column(name = "STOCK", nullable = false, precision = 19, scale = 3)
    @NotNull
    private BigDecimal stock;

    @NumberFormat(pattern = "#,##0.00", decimalSeparator = ",", groupingSeparator = ".")
    @Column(name = "MINIMUM_STOCK", precision = 19, scale = 3)
    private BigDecimal minimumStock;

    @NumberFormat(pattern = "#,##0.00", decimalSeparator = ",", groupingSeparator = ".")
    @Column(name = "RETAIL_PRICE", nullable = false, precision = 19, scale = 2)
    @NotNull
    private BigDecimal retailPrice;

    @NumberFormat(pattern = "#,##0.00", decimalSeparator = ",", groupingSeparator = ".")
    @Column(name = "WHOLESALE_PRICE", precision = 19, scale = 2)
    private BigDecimal wholesalePrice;

    @NumberFormat(pattern = "#,##0.000", decimalSeparator = ",", groupingSeparator = ".")
    @Column(name = "QUANTITY_FOR_WHOLESALE", precision = 19, scale = 3)
    private BigDecimal quantityForWholesale;

    @CreatedBy
    @Column(name = "CREATED_BY")
    private String createdBy;

    @CreatedDate
    @Column(name = "CREATED_DATE")
    private OffsetDateTime createdDate;

    @LastModifiedBy
    @Column(name = "LAST_MODIFIED_BY")
    private String lastModifiedBy;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_DATE")
    private OffsetDateTime lastModifiedDate;

    public BigDecimal getMinimumStock() {
        return minimumStock;
    }

    public void setMinimumStock(BigDecimal minimumStock) {
        this.minimumStock = minimumStock;
    }

    public BigDecimal getQuantityForWholesale() {
        return quantityForWholesale;
    }

    public void setQuantityForWholesale(BigDecimal quantityForWholesale) {
        this.quantityForWholesale = quantityForWholesale;
    }

    public BigDecimal getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(BigDecimal wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(OffsetDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public OffsetDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(OffsetDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}