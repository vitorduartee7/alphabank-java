import model.*;
import service.*;
import util.*;
import java.awt.*;

public class Main {
    private static final BancoService banco = new BancoService();

    public static void main(String[] args) {
        executarMenuInicial();
    }

    public static void executarMenuInicial() {
        int opcao;
        do {
            MenuUtil.mostrarMenuInicial();
            opcao = MenuUtil.lerInt("");
            switch (opcao) {
                case 1: fazerLogin();  break;
                case 2: criarUsuario();  break;
                default: break;
            }
        } while (opcao != 0);
    }

    public static void executarMenuPrincipal() {
        Conta conta = banco.getContaUsuarioLogado();
        int opcao;
        do {
            MenuUtil.mostrarMenuPrincipal(banco.getUsuarioLogado(), conta.getSaldo());
            opcao = MenuUtil.lerInt("");
            switch (opcao) {
                case 1: depositar(); break;
                case 2: sacar(); break;
                case 3: transferir(); break;
                case 4: aplicarRendimentos();  break;
                case 5: fazerLogout(); return;
                default: break;
            }
        } while (opcao != 0);
    }

    public static void criarUsuario(){
        System.out.println("\n=============");
        String nome = MenuUtil.lerString("Nome: ");
        String dataNascimento = MenuUtil.lerString("Data de Nascimento: ");
        String cpf = MenuUtil.lerString("CPF: ");
        System.out.println("=============");
        String senha = MenuUtil.lerString("Senha: ");
        String senha2 = MenuUtil.lerString("Digite a Senha novamente: ");
        System.out.println("=============");
        String conta = MenuUtil.lerString("Tipo de Conta (Corrente ou Poupança): ");

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

        if (!ValidadorUtil.validarSenha(senha)) {
            System.out.println("\n=============");
            System.out.println("""
                    A senha deve ter:
                            - 8+ caracteres
                            - 1 MAIÚSCULA (A-Z)
                            - 1 número (0-9)
                            - 1 especial (@#$%^&+=!?-)
                            - 1 minúscula (a-z)""");
            System.out.println("=============");
            return;
        }
        if (!senha2.equals(senha)) {
            System.out.println("\n=============");
            System.out.println("A senha deve ser igual!");
            System.out.println("=============");
            return;
        }

        Usuario titular = new Usuario(nome, cpf, dataNascimento, senha);

        if (banco.cadastrarUsuario(titular)) {
            if (conta.equalsIgnoreCase("Corrente")) {
                Conta cc = banco.criarContaCorrente(titular);
                System.out.println("\n=============");
                System.out.println("Conta criada: " + cc.getNumeroConta());
            } else if (conta.equalsIgnoreCase("Poupanca")) {
                Conta cp = banco.criarContaPoupanca(titular);
                System.out.println("\n=============");
                System.out.println("Conta criada: " + cp.getNumeroConta());
            }
            System.out.println("Cadastro realizado com sucesso!");
            System.out.println("=============");
        } else {
            System.out.println("\n=============");
            System.out.println("Erro ao cadastrar!");
            System.out.println("=============");
        }
    }

    public static void fazerLogin(){
        System.out.println("\n=============");
        String cpf = MenuUtil.lerString("CPF: ");
        String senha = MenuUtil.lerString("Senha: ");
        System.out.println("=============");

        if (banco.login(cpf, senha)) {
            System.out.println("=============");
            System.out.println("Login realizado com sucesso!");
            System.out.println("=============");
            executarMenuPrincipal();
        } else {
            System.out.println("\n=============");
            System.out.println("Erro ao fazer login!");
            System.out.println("=============");
        }
    }

    public static void fazerLogout(){
        banco.logout();
        System.out.println("\n=============");
        System.out.println("Logout realizado!");
        System.out.println("=============");
    }

    public static void depositar(){
        Conta conta = banco.getContaUsuarioLogado();
        if (conta == null) {
            System.out.println("\n=============");
            System.out.println("Conta inexistente!");
            System.out.println("=============");
            return;
        }

        System.out.println("\n=============");
        double valor = MenuUtil.lerDouble("Valor do deposito: ");
        System.out.println("=============");

        if (conta.depositar(valor)) {
            System.out.println("\n=============");
            System.out.println("Depositado com sucesso!");
            System.out.println("Saldo Atual: " + ValidadorUtil.formatarMoeda(conta.getSaldo()));
            System.out.println("=============");
        } else {
            System.out.println("\n=============");
            System.out.println("Erro no deposito!");
            System.out.println("=============");
        }
    }

    public static void sacar(){
        Conta conta = banco.getContaUsuarioLogado();
        if (conta == null) {
            System.out.println("\n=============");
            System.out.println("Conta inexistente!");
            System.out.println("=============");
            return;
        }

        System.out.println("\n=============");
        double valor = MenuUtil.lerDouble("Valor do saque: ");
        System.out.println("=============");

        if (conta.sacar(valor)) {
            System.out.println("\n=============");
            System.out.println("Saque realizado com sucesso!");
            System.out.println("Saldo Atual: " + ValidadorUtil.formatarMoeda(conta.getSaldo()));
            System.out.println("=============");
        } else {
            System.out.println("\n=============");
            System.out.println("Erro no saque!");
            System.out.println("=============");
        }
    }

    public static void transferir(){
        Conta conta = banco.getContaUsuarioLogado();
        if (conta == null) {
            System.out.println("\n=============");
            System.out.println("Conta inexistente!");
            System.out.println("=============");
            return;
        }

        System.out.println("\n=============");
        String destino = MenuUtil.lerString("Conta destino: ");
        double valor = MenuUtil.lerDouble("Valor da transferencia: ");
        System.out.println("=============");


        if (banco.transferir(conta.getNumeroConta(), destino, valor)) {
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
        Conta conta = banco.getContaUsuarioLogado();
        if (conta == null) {
            System.out.println("\n=============");
            System.out.println("Conta inexistente!");
            System.out.println("=============");
            return;
        }

        System.out.println("\n=============");
        System.out.println("Aplicando Rendimentos...");
        System.out.println("=============");

        double rendimento = conta.calcularRendimento();
        if (rendimento > 0) {
            conta.depositar(rendimento);
            System.out.println("\n=============");
            System.out.println("Rendimento " + conta.getNumeroConta() + ": "
                    + ValidadorUtil.formatarMoeda(rendimento));
            System.out.println("=============");
        }
    }
}