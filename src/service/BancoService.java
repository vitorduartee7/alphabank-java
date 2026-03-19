package service;

import model.*;
import java.util.ArrayList;

public class BancoService {
    private Usuario usuarioLogado;
    private final ArrayList<Usuario> usuarios = new ArrayList<>();
    private final ArrayList<Conta> contas = new ArrayList<>();

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public Usuario getUsuarioLogado() {
        return usuarioLogado;
    }

    public Conta getContaUsuarioLogado() {
        for (Conta c : contas) {
            if (c.getTitular().equals(usuarioLogado)) {
                return c;
            }
        }
        return null;
    }
    
    public boolean cadastrarUsuario(Usuario titular) {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(titular.getCpf())) {
                return false;
            }
        }
        usuarios.add(titular);
        return true;
    }

    public boolean login(String cpf, String senha) {
        for (Usuario u : usuarios) {
            if (u.getCpf().equals(cpf)) {
                if (u.autenticarSenha(senha)) {
                    usuarioLogado = u;
                    return true;
                } else return false;
            }
        }
        return false;
    }

    public void logout() {
        usuarioLogado = null;
    }

    public Conta criarContaCorrente(Usuario titular) {
        String numeroConta = "CC" + (contas.size() + 1);
        ContaCorrente cc = new ContaCorrente(numeroConta, "0001", titular, 500);
        contas.add(cc);
        return cc;
    }

    public Conta criarContaPoupanca(Usuario titular) {
        String numeroConta = "CP" + (contas.size() + 1);
        ContaPoupanca cp = new ContaPoupanca(numeroConta, "0001", titular, 0.67);
        contas.add(cp);
        return cp;
    }

    public Conta buscarContaPorNumero(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numero)) return conta;
        }
        return null;
    }

    public boolean transferir(String origemNum, String destinoNum, double valor){
        Conta origem = buscarContaPorNumero(origemNum);
        Conta destino = buscarContaPorNumero(destinoNum);
        if (origem != null && destino != null)
            return origem.transferir(destino, valor);
        return false;
    }
}
