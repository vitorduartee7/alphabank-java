package util;

public class ValidadorUtil {
    public static boolean validarNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) return false;
        String nomeLimpo = nome.trim();
        if(!nomeLimpo.matches("[a-zA-Zà-úÀ-Ú ]+")) {
            return false;
        }
        return nomeLimpo.length() >= 2;
    }

    public static boolean validarCPF(String cpf) {
        if (cpf == null) return false;
        String cpfLimpo = cpf.replaceAll("[^0-9]", "");
        if (cpfLimpo.length() != 11) return false;
        return !cpfLimpo.equals("00000000000");
    }

    public static boolean validarDataNascimento(String data) {
        if (data == null && data.length() != 10) return false;
        try {
            String[] partes = data.split("/");
            if (partes.length != 3) return false;

            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);

            if (dia < 1 || dia > 31) return false;
            if (mes < 1 || mes > 12) return false;
            return ano >= 1900 && ano <= 2026;
        } catch (Exception e) {
            return false;
        }
    }

    public static String formatarMoeda(double valor) {
        return String.format("R$ %.2f", valor)
                .replace(".", ",")
                .replace(",,", ",");
    }
}
