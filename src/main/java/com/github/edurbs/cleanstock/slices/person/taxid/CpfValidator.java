package com.github.edurbs.cleanstock.slices.person.taxid;

public class CpfValidator  {

    public boolean isValid(String cpf) {
        cpf = cpf.replaceAll("[^0-9]", "");

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        try {
            // Calcula primeiro dígito verificador
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int firstDigit = 11 - (sum % 11);
            if (firstDigit >= 10) firstDigit = 0;

            // Calcula segundo dígito verificador
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int secondDigit = 11 - (sum % 11);
            if (secondDigit >= 10) secondDigit = 0;

            return Character.getNumericValue(cpf.charAt(9)) == firstDigit &&
                    Character.getNumericValue(cpf.charAt(10)) == secondDigit;

        } catch (Exception e) {
            return false;
        }
    }


}
