package com.github.edurbs.cleanstock.slices.person.cpf;

import com.github.edurbs.cleanstock.slices.person.taxid.CpfValidator;
import com.github.edurbs.cleanstock.test_support.HumanPhraseDisplayNameGenerator;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayNameGeneration(HumanPhraseDisplayNameGenerator.class)
class CpfValidatorTest {

    @Test
    void givenValidCpf_whenValidate_thenTrue() {
        CpfValidator validator = new CpfValidator();

        String cpf = "12345678909";
        assertTrue(validator.isValid(cpf));
    }

    @Test
    void givenInvalidCpf_whenValidate_thenFalse() {
        CpfValidator validator = new CpfValidator();

        String cpf = "12345678901";
        assertFalse(validator.isValid(cpf));
    }

    @Test
    void givenTextCpf_whenValidate_thenFalse() {
        CpfValidator validator = new CpfValidator();

        String cpf = "invalid-cpf";
        assertFalse(validator.isValid(cpf));
    }
}
