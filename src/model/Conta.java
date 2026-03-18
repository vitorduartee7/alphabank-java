package model;

public abstract class Conta {
    private final String numeroConta;
    private final String agencia;
    private double saldo = 0;
    private final Pessoa titular;

    public Conta(String numeroConta, String agencia, Pessoa titular) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.titular = titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public String getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public Pessoa getTitular() {
        return titular;
    }

    public abstract double calcularRendimento();

    public boolean sacar(double valor) {
        if (valor <= getSaldo()) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    public boolean depositar(double valor) {
        if (valor > 0){
            saldo += valor;
            return true;
        }
        return false;
    }

    public boolean transferir(Conta destino, double valor) {
        if (valor <= getSaldo()) {
            saldo -= valor;
            destino.depositar(valor);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numeroConta='" + numeroConta + '\'' +
                ", agencia='" + agencia + '\'' +
                ", saldo=" + saldo +
                ", titular=" + titular +
                '}';
    }
}
