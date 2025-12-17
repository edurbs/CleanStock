package com.github.edurbs.cleanstock.slices.person.taxid;

public class CnpjValidator {

    public boolean isValid(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", "");

        if (cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        try {
            // Calcula primeiro dígito verificador
            int[] weight1 = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            int sum = 0;
            for (int i = 0; i < 12; i++) {
                sum += Character.getNumericValue(cnpj.charAt(i)) * weight1[i];
            }
            int firstDigit = sum % 11;
            firstDigit = firstDigit < 2 ? 0 : 11 - firstDigit;

            // Calcula segundo dígito verificador
            int[] weight2 = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};
            sum = 0;
            for (int i = 0; i < 13; i++) {
                sum += Character.getNumericValue(cnpj.charAt(i)) * weight2[i];
            }
            int secondDigit = sum % 11;
            secondDigit = secondDigit < 2 ? 0 : 11 - secondDigit;

            return Character.getNumericValue(cnpj.charAt(12)) == firstDigit &&
                    Character.getNumericValue(cnpj.charAt(13)) == secondDigit;

        } catch (Exception e) {
            return false;
        }
    }
}
