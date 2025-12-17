package com.github.edurbs.cleanstock.slices.producttransaction;

import com.github.edurbs.cleanstock.slices.person.Consumer;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@JmixEntity
@Entity
public class Sale extends ProductTransaction {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    private Consumer customer;

    public Consumer getCustomer() {
        return customer;
    }

    public void setCustomer(Consumer customer) {
        this.customer = customer;
    }

}