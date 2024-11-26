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
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Data de Nascimento: " + dataNascimento);
    }
}
