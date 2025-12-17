package com.github.edurbs.cleanstock.slices.producttransaction;

import com.github.edurbs.cleanstock.slices.person.Supplier;
import io.jmix.core.metamodel.annotation.JmixEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@JmixEntity
@Entity
public class Purchase extends ProductTransaction {
    @JoinColumn(name = "SUPPLIER_ID")
    @ManyToOne(fetch = FetchType.LAZY)
    private Supplier supplier;

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

}