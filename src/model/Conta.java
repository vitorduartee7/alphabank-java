package model;

public class Conta {
    final private String numeroConta;
    final private String agencia;
    private double saldo;
    final private Pessoa titular;

    public Conta(String numeroConta, String agencia, double saldo, Pessoa titular) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.titular = titular;
        this.saldo = 0;
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

    public double calcularRendimento() {
        return 0;
    }

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
