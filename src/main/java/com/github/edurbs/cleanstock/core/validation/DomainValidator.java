package com.github.edurbs.cleanstock.core.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

import java.util.Set;

public class DomainValidator {

    private final Validator validator;

    public DomainValidator(Validator validator) {
        this.validator = validator;
    }

    /**
     * Validates an object and throws ValidationException if violations exist
     * @param object the object to validate
     * @param <T> the type of object
     * @throws BusinessValidationException if validation fails
     */
    public <T> void validate(T object) {
        Set<ConstraintViolation<T>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new BusinessValidationException(violations);
        }
    }

    /**
     * Validates an object with specific validation groups
     * @param object the object to validate
     * @param groups validation groups
     * @param <T> the type of object
     * @throws BusinessValidationException if validation fails
     */
    public <T> void validate(T object, Class<?>... groups) {
        Set<ConstraintViolation<T>> violations = validator.validate(object, groups);
        if (!violations.isEmpty()) {
            throw new BusinessValidationException(violations);
        }
    }

    /**
     * Validates a specific property of an object
     * @param object the object containing the property
     * @param propertyName name of the property to validate
     * @param <T> the type of object
     * @throws BusinessValidationException if validation fails
     */
    public <T> void validateProperty(T object, String propertyName) {
        Set<ConstraintViolation<T>> violations = validator.validateProperty(object, propertyName);
        if (!violations.isEmpty()) {
            throw new BusinessValidationException(violations);
        }
    }

    /**
     * Checks if an object is valid without throwing exception
     * @param object the object to validate
     * @param <T> the type of object
     * @return true if valid, false otherwise
     */
    public <T> boolean isValid(T object) {
        return validator.validate(object).isEmpty();
    }

    /**
     * Gets validation violations without throwing exception
     * @param object the object to validate
     * @param <T> the type of object
     * @return set of constraint violations (empty if valid)
     */
    public <T> Set<ConstraintViolation<T>> getViolations(T object) {
        return validator.validate(object);
    }
}
