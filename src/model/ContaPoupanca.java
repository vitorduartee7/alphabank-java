package model;

public class ContaPoupanca extends Conta{
    private final double taxaJurosMensal;

    public ContaPoupanca(String numeroConta, String agencia, Pessoa titular, double taxaJurosMensal) {
        super(numeroConta, agencia, titular);
        this.taxaJurosMensal = taxaJurosMensal;
    }

    @Override
    public double calcularRendimento() {
        return getSaldo() * taxaJurosMensal;
    }
}
