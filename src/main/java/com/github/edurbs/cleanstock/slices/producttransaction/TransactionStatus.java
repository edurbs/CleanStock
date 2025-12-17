package com.github.edurbs.cleanstock.slices.producttransaction;

import io.jmix.core.metamodel.datatype.EnumClass;
import org.springframework.lang.Nullable;

public enum TransactionStatus implements EnumClass<String> {

    ;

    private final String id;

    TransactionStatus(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static TransactionStatus fromId(String id) {
        for (TransactionStatus at : TransactionStatus.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}