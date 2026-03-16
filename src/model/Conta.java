package model;

public abstract class Conta {
    private String numeroConta;
    private String agencia;
    private double saldo;
    private Pessoa titular;

    public Conta(String numeroConta, String agencia, double saldo, Pessoa titular) {
        setNumeroConta(numeroConta);
        setAgencia(agencia);
        setTitular(titular);
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

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public void setTitular(Pessoa titular) {
        this.titular = titular;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
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
