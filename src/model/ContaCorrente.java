package model;

public class ContaCorrente extends Conta{
    private double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, String agencia, double saldo, Pessoa titular, double limite) {
        super(numeroConta, agencia, saldo, titular);
        this.limiteChequeEspecial = limite;
    }

    @Override
    public double calcularRendimento() {
        return 0;
    }
}
