import model.*;
import service.*;
import util.*;

public class Main {
    private static final BancoService banco = new BancoService();

    public static void main(String[] args) {
        executar();
    }

    public static void executar(){
        int opcao;
        do {
            MenuUtil.mostrarMenuPrincipal();
            opcao = MenuUtil.lerInt("");
            switch (opcao) {
                case 1: criarCorrente(); break;
                case 2: criarPoupanca(); break;
                case 3: depositar(); break;
                case 4: sacar(); break;
                case 5: transferir(); break;
                case 6: aplicarRendimentos();  break;
                case 7: listarContas(); break;
                default: break;
            }
        } while (opcao != 0);
    }

    public static void criarCorrente(){
        System.out.println("\n=============");
        String nome = MenuUtil.lerString("Nome: ");
        String cpf = MenuUtil.lerString("CPF: ");
        String dataNascimento = MenuUtil.lerString("Data de Nascimento: ");
        System.out.println("=============");

        if(!ValidadorUtil.validarNome(nome)) {
            System.out.println("\n=============");
            System.out.println("Nome inválido!");
            System.out.println("=============");
            return;
        }

        if (!ValidadorUtil.validarCPF(cpf)) {
            System.out.println("\n=============");
            System.out.println("CPF invalido!");
            System.out.println("=============");
            return;
        }

        if (!ValidadorUtil.validarDataNascimento(dataNascimento)) {
            System.out.println("\n=============");
            System.out.println("Data inválida! Use dd/mm/yyyy");
            System.out.println("=============");
            return;
        }

        Pessoa titular = new Pessoa(nome, cpf, dataNascimento);
        Conta cc = banco.criarContaCorrente(titular);
        System.out.println("\n=============");
        System.out.println("Conta criada: " + cc.getNumeroConta());
        System.out.println("=============");
    }

    public static void criarPoupanca(){
        System.out.println("\n=============");
        String nome = MenuUtil.lerString("Nome: ");
        String cpf = MenuUtil.lerString("CPF: ");
        String dataNascimento = MenuUtil.lerString("Data de Nascimento: ");
        System.out.println("=============");

        if(!ValidadorUtil.validarNome(nome)) {
            System.out.println("\n=============");
            System.out.println("Nome inválido!");
            System.out.println("=============");
            return;
        }

        if (!ValidadorUtil.validarCPF(cpf)) {
            System.out.println("\n=============");
            System.out.println("CPF invalido!");
            System.out.println("=============");
            return;
        }

        if (!ValidadorUtil.validarDataNascimento(dataNascimento)) {
            System.out.println("Data inválida! Use dd/mm/yyyy");
            return;
        }

        Pessoa titular = new Pessoa(nome, cpf, dataNascimento);
        Conta cp = banco.criarContaPoupanca(titular);
        System.out.println("\n=============");
        System.out.println("Conta criada: " + cp.getNumeroConta());
        System.out.println("=============");
    }

    public static void depositar(){
        System.out.println("\n=============");
        String num = MenuUtil.lerString("Conta: ");
        System.out.println("=============");
        Conta c = banco.buscarContaPorNumero(num);

        if (c == null) {
            System.out.println("\n=============");
            System.out.println("Conta nao encontrada!");
            System.out.println("=============");
            return;
        }

        System.out.println("\n=============");
        double valor = MenuUtil.lerDouble("Valor do deposito: ");
        System.out.println("=============");

        if (c.depositar(valor)) {
            System.out.println("\n=============");
            System.out.println("Depositado com sucesso!\nSaldo Atual: "
                    + ValidadorUtil.formatarMoeda(c.getSaldo()));
            System.out.println("=============");
        } else {
            System.out.println("\n=============");
            System.out.println("Erro no deposito!");
            System.out.println("=============");
        }
    }

    public static void sacar(){
        System.out.println("\n=============");
        String num = MenuUtil.lerString("Numero da conta: ");
        System.out.println("=============");
        Conta c = banco.buscarContaPorNumero(num);

        if (c == null) {
            System.out.println("\n=============");
            System.out.println("Conta nao encontrada!");
            System.out.println("=============");
            return;
        }

        System.out.println("\n=============");
        double valor = MenuUtil.lerDouble("Valor da saque: ");
        System.out.println("=============");

        if (c.sacar(valor)) {
            System.out.println("\n=============");
            System.out.println("Saque realizado com sucesso!\nSaldo Atual: "
                    + ValidadorUtil.formatarMoeda(c.getSaldo()));
            System.out.println("=============");
        } else {
            System.out.println("\n=============");
            System.out.println("Erro no saque!");
            System.out.println("=============");
        }
    }

    public static void transferir(){
        System.out.println("\n=============");
        String origem = MenuUtil.lerString("Conta origem: ");
        String destino = MenuUtil.lerString("Conta destino: ");
        double valor = MenuUtil.lerDouble("Valor da transferencia: ");
        System.out.println("=============");

        if (banco.transferir(origem, destino, valor)) {
            System.out.println("\n=============");
            System.out.println("Transferencia realizada com sucesso!");
            System.out.println("=============");
        } else {
            System.out.println("\n=============");
            System.out.println("Erro na transferencia!");
            System.out.println("=============");
        }
    }

    public static void aplicarRendimentos(){
        System.out.println("\n=============");
        System.out.println("Aplicando Rendimentos...");
        System.out.println("=============");

        for (Conta c : banco.getContas()) {
            double rendimento = c.calcularRendimento();
            if (rendimento > 0) {
                c.depositar(rendimento);
                System.out.println("\n=============");
                System.out.println("Rendimento " + c.getNumeroConta() + ": "
                        + ValidadorUtil.formatarMoeda(rendimento));
                System.out.println("=============");
            }
        }
    }

    public static void listarContas(){
        if(banco.getContas().isEmpty()) {
            System.out.println("=============");
            System.out.println("Nenhuma conta cadastrada!");
            System.out.println("=============");
            return;
        }

        System.out.println("\nEXTRATO COMPLETO:");
        System.out.println("═".repeat(60));

        for(int i = 0; i < banco.getContas().size(); i++) {
            Conta c = banco.getContas().get(i);
            System.out.printf("[%d] %-10s | %-6s | %-12s | %s%n",
                    i+1,
                    c.getNumeroConta(),
                    c.getAgencia(),
                    ValidadorUtil.formatarMoeda(c.getSaldo()),
                    c.getTitular().nome()
            );
        }
        System.out.println("═".repeat(60));
    }
}