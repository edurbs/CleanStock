package com.github.edurbs.cleanstock.slices.person;

import io.jmix.core.metamodel.annotation.JmixEntity;
import io.jmix.core.metamodel.annotation.NumberFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import java.math.BigDecimal;

@JmixEntity
@Entity
public class Consumer extends Person {
    @NumberFormat(pattern = "#,##0.00", decimalSeparator = ",", groupingSeparator = ".")
    @Column(name = "CREDIT_LIMIT", precision = 19, scale = 2)
    private BigDecimal creditLimit;

    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

}