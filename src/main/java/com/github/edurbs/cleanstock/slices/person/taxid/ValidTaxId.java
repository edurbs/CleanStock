package com.github.edurbs.cleanstock.slices.person.taxid;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TaxIdValidator.class)
@Documented
public @interface ValidTaxId {
    String message() default "CPF ou CNPJ inválido";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String taxIdField() default "taxId";
    String typeField() default "personType";
}