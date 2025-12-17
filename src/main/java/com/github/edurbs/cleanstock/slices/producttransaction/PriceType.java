package com.github.edurbs.cleanstock.slices.producttransaction;

import io.jmix.core.metamodel.datatype.EnumClass;
import org.springframework.lang.Nullable;

public enum PriceType implements EnumClass<String> {

    RETAIL("R"),
    WHOLESALE("W");

    private final String id;

    PriceType(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static PriceType fromId(String id) {
        for (PriceType at : PriceType.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}