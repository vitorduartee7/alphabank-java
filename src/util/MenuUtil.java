package util;

import model.*;
import java.util.Scanner;

public class MenuUtil {
    private static final Scanner input = new Scanner(System.in);

    public static void mostrarMenuInicial() {
        System.out.println("\n=== ALPHA BANK ===");
        System.out.println("[1] Fazer Login");
        System.out.println("[2] Criar Conta");
        System.out.println("[0] Sair");
        System.out.print("Escolha: ");
    }

    public static void mostrarMenuPrincipal(Usuario usuario, Double saldo){
        System.out.println("\n=== ALPHA BANK ===");
        mostrarExtrato(usuario, saldo);
        System.out.println("[1] Depositar");
        System.out.println("[2] Sacar");
        System.out.println("[3] Transferir");
        System.out.println("[4] Aplicar Rendimentos");
        System.out.println("[5] Logout");
        System.out.println("[0] Sair");
        System.out.print("Escolha: ");
    }

    public static void mostrarExtrato(Usuario usuario, Double saldo) {
        System.out.println("=============");
        System.out.printf(usuario.getNome() + " R$ %.2f", saldo);
        System.out.println("\n=============");
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while(!input.hasNextInt()) {
            System.out.println("\n=============");
            System.out.println("Digite um número válido!");
            System.out.println("=============");
            input.next();
        }
        int valor = input.nextInt();
        input.nextLine();
        return valor;
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while(!input.hasNextDouble()) {
            System.out.println("\n=============");
            System.out.println("Digite um número válido!");
            System.out.println("=============");
            input.next();
        }
        double valor = input.nextDouble();
        input.nextLine();
        return valor;
    }

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return input.nextLine().trim();
    }
}
