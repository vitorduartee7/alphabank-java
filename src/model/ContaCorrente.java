package model;

public class ContaCorrente extends Conta{
    final private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, String agencia, double saldo, Pessoa titular, double limite) {
        super(numeroConta, agencia, saldo, titular);
        this.limiteChequeEspecial = limite;
    }
}
