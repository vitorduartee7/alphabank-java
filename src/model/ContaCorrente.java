package model;

public class ContaCorrente extends Conta{
    private final double limiteChequeEspecial;

    public ContaCorrente(String numeroConta, String agencia, Pessoa titular, double limite) {
        super(numeroConta, agencia, titular);
        this.limiteChequeEspecial = limite;
    }

    @Override
    public double calcularRendimento() {
        return 0;
    }
}
