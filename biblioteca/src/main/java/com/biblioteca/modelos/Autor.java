package com.biblioteca.modelos;

public class Autor extends Pessoa {
    private String dataNascimento;

    public Autor(String nome, String endereco, String dataNascimento) {
        super(nome, endereco);
        this.dataNascimento = dataNascimento;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + ", Data de Nascimento: " + dataNascimento;
    }
}
