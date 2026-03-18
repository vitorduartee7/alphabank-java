package model;

import java.util.ArrayList;

public class Usuario extends Pessoa {
    private final String senha;
    private final ArrayList<String> contasAutorizadas;

    public Usuario(String nome, String cpf, String dataNascimento, String senha) {
        super(nome, cpf, dataNascimento);
        this.senha = senha;
        this.contasAutorizadas = new ArrayList<>();
    }

    public boolean autenticarSenha(String senha) {
        return this.senha.equals(senha);
    }

    public void adicionarConta(String numeroConta) {
        contasAutorizadas.add(numeroConta);
    }

    public boolean podeAcessar(String numeroConta) {
        return contasAutorizadas.contains(numeroConta);
    }
}
