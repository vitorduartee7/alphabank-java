package util;

import model.Conta;
import service.BancoService;

import java.util.Scanner;

public class MenuUtil {
    private static final Scanner input = new Scanner(System.in);
    private static final BancoService service = new BancoService();

    public static void mostrarMenuInicial() {
        System.out.println("\n=== ALPHA BANK ===");
        System.out.println("[1] Fazer Login");
        System.out.println("[2] Criar Conta");
        System.out.println("[0] Sair");
        System.out.print("Escolha: ");
    }

    public static void mostrarMenuPrincipal(){
        System.out.println("\n=== ALPHA BANK ===");
        mostrarExtrato();
        System.out.println("[1] Depositar");
        System.out.println("[2] Sacar");
        System.out.println("[3] Transferir");
        System.out.println("[4] Aplicar Rendimentos");
        System.out.println("[5] Logout");
        System.out.println("[0] Sair");
        System.out.print("Escolha: ");
    }

    public static void mostrarExtrato(){
        System.out.println("\n=============");
        System.out.println("SALDO:");
        System.out.println("═".repeat(60));

        for(int i = 0; i < service.getContas().size(); i++) {
            Conta c = service.getContas().get(i);
            System.out.printf("[%d] %-10s | %-6s | %-12s | %s%n",
                    i+1,
                    c.getNumeroConta(),
                    c.getAgencia(),
                    ValidadorUtil.formatarMoeda(c.getSaldo()),
                    c.getTitular().getNome()
            );
        }
        System.out.println("═".repeat(60));
    }

    public static int lerInt(String mensagem) {
        System.out.print(mensagem);
        while(!input.hasNextInt()) {
            System.out.println("Digite um número válido!");
            input.next();
        }
        int valor = input.nextInt();
        input.nextLine();
        return valor;
    }

    public static double lerDouble(String mensagem) {
        System.out.print(mensagem);
        while(!input.hasNextDouble()) {
            System.out.println("Digite um número válido!");
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
