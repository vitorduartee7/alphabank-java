package model;

import java.util.ArrayList;

public class Usuario {
    private final String nome;
    private final String cpf;
    private final String dataNascimento;
    private final String senha;
    private final ArrayList<String> contasAutorizadas;

    public Usuario(String nome, String cpf, String dataNascimento, String senha) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.senha = senha;
        this.contasAutorizadas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public boolean autenticarSenha(String senha) {
        return this.senha.equals(senha);
    }
}
