package com.github.edurbs.cleanstock.slices.person.taxid;

import com.github.edurbs.cleanstock.slices.person.PersonType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;

public class TaxIdValidator implements ConstraintValidator<ValidTaxId, Object> {

    private String taxIdFieldName;
    private String typeFieldName;

    private final CpfValidator cpfValidator = new CpfValidator();
    private final CnpjValidator cnpjValidator = new CnpjValidator();

    @Override
    public void initialize(ValidTaxId annotation) {
        this.taxIdFieldName = annotation.taxIdField();
        this.typeFieldName = annotation.typeField();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        if (object == null) {
            return true;
        }

        try {
            Field taxIdField = findField(object.getClass(), taxIdFieldName);
            Field typeField = findField(object.getClass(), typeFieldName);

            taxIdField.setAccessible(true);
            typeField.setAccessible(true);

            Object rawTaxId = taxIdField.get(object);
            Object rawType = typeField.get(object);
            String taxId = (rawTaxId == null) ? null : rawTaxId.toString();
            PersonType tipo = coercePersonType(rawType);


            if (taxId == null || tipo == null) {
                return true; // Use @NotNull for requiredness
            }

            boolean valid;
            String message;

            if (tipo == PersonType.INDIVIDUAL) {
                valid = isValidCPF(taxId);
                message = "CPF inválido";
            } else if (tipo == PersonType.COMPANY) {
                valid = isValidCNPJ(taxId);
                message = "CNPJ inválido";
            } else {
                // Unknown type: don't fail hard, treat as "not validated here"
                return true;
            }

            if (!valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(message)
                        .addPropertyNode(taxIdFieldName)
                        .addConstraintViolation();
            }

            return valid;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao validar Tax ID", e);
        }
    }

    private PersonType coercePersonType(Object rawType) {
        if (rawType == null) {
            return null;
        }
        if (rawType instanceof PersonType pt) {
            return pt;
        }
        if (rawType instanceof String s) {
            return PersonType.fromId(s);
        }
        // Last resort: try string conversion (helps if it's some proxy/other type)
        return PersonType.fromId(rawType.toString());
    }


    private Field findField(Class<?> type, String fieldName) throws NoSuchFieldException {
        Class<?> current = type;
        while (current != null && current != Object.class) {
            try {
                return current.getDeclaredField(fieldName);
            } catch (NoSuchFieldException ignored) {
                current = current.getSuperclass();
            }
        }
        throw new NoSuchFieldException(fieldName);
    }

    private boolean isValidCPF(String cpf) {
        return cpfValidator.isValid(cpf);

    }

    private boolean isValidCNPJ(String cnpj) {
        return cnpjValidator.isValid(cnpj);
    }
}