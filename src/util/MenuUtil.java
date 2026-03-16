package util;

import java.util.Scanner;

public class MenuUtil {
    private static Scanner input = new Scanner(System.in);

    public static void mostrarMenuPrincipal(){
        System.out.println("\n=== ALPHA BANK ===");
        System.out.println("[1] Criar Conta Corrente");
        System.out.println("[2] Criar Conta Poupança");
        System.out.println("[3] Depositar");
        System.out.println("[4] Sacar");
        System.out.println("[5] Transferir");
        System.out.println("[6] Aplicar Rendimentos");
        System.out.println("[7] Listar Contas");
        System.out.println("[0] Sair");
        System.out.print("Escolha: ");
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        return input.nextInt();
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        return input.nextDouble();
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        input.nextLine();
        return input.next();

    }
}
