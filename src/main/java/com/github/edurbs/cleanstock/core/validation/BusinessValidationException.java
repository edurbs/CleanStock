package com.github.edurbs.cleanstock.core.validation;

import jakarta.validation.ConstraintViolation;

import java.util.Set;

public class BusinessValidationException extends RuntimeException {
    private final Set<? extends ConstraintViolation<?>> violations;

    public BusinessValidationException(Set<? extends ConstraintViolation<?>> violations) {
        super("Validation failed: " + violations.toString());
        this.violations = violations;
    }

    public Set<? extends ConstraintViolation<?>> getViolations() {
        return violations;
    }
}
