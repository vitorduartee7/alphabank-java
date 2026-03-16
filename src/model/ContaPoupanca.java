package model;

public class ContaPoupanca extends Conta{
    private double taxaJurosMensal;

    public ContaPoupanca(String numeroConta, String agencia, double saldo, Pessoa titular, double taxaJurosMensal) {
        super(numeroConta, agencia, saldo, titular);
        this.taxaJurosMensal = taxaJurosMensal;
    }

    @Override
    public double calcularRendimento() {
        return getSaldo() * taxaJurosMensal;
    }
}
