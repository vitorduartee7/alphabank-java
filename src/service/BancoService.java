package service;
import model.*;

import java.util.ArrayList;

public class BancoService {
    private ArrayList<Conta> contas = new ArrayList<>();

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public Conta criarContaCorrente(Pessoa titular) {
        String numeroConta = "CC" + (contas.size() + 1);
        ContaCorrente cc = new ContaCorrente(numeroConta, "0001", 0, titular, 500);
        contas.add(cc);
        return cc;
    }

    public Conta criarContaPoupanca(Pessoa titular) {
        String numeroConta = "CP" + (contas.size() + 1);
        ContaPoupanca cp = new ContaPoupanca(numeroConta, "0001", 0, titular, 0.67);
        contas.add(cp);
        return cp;
    }

    public Conta buscarContaPorNumero(String numero) {
        for (Conta conta : contas) {
            if (conta.getNumeroConta().equals(numero)) return conta;
        }
        return null;
    }

    public void listarTodasContas() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }

    public boolean transferir(String origemNum, String destinoNum, double valor){
        Conta origem = buscarContaPorNumero(origemNum);
        Conta destino = buscarContaPorNumero(destinoNum);
        if (origem != null && destino != null)
            return origem.transferir(destino, valor);
        return false;
    }
}
