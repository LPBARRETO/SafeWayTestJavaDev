public class ValidadorCNPJ {
    public static boolean validarCnpj(String cnpj) {
        cnpj = cnpj.replaceAll("[^0-9]", ""); 

        if (cnpj.length() != 14 || cnpj.matches("(\\d)\\1{13}")) {
            return false;
        }

        int[] pesos1 = { 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };
        int[] pesos2 = { 6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2 };

        int soma1 = 0, soma2 = 0;
        for (int i = 0; i < 12; i++) {
            int digito = Character.getNumericValue(cnpj.charAt(i));
            soma1 += digito * pesos1[i];
            soma2 += digito * pesos2[i];
        }

        int digito1 = (soma1 % 11 < 2) ? 0 : 11 - (soma1 % 11);
        soma2 += digito1 * pesos2[12];
        int digito2 = (soma2 % 11 < 2) ? 0 : 11 - (soma2 % 11);

        return digito1 == Character.getNumericValue(cnpj.charAt(12)) &&
                digito2 == Character.getNumericValue(cnpj.charAt(13));
    }
}
