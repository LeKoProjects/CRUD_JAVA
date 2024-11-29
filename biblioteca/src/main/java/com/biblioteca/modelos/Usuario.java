package com.biblioteca.modelos;

public class Usuario extends Pessoa {
    private String historicoEmprestimos;

    public Usuario(String nome, String endereco) {
        super(nome, endereco);
        this.historicoEmprestimos = "";
    }

    public String getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public void adicionarEmprestimo(String titulo) {
        historicoEmprestimos += titulo + "; ";
    }

    @Override
    public String exibirInformacoes() {
        return super.exibirInformacoes() + ", Histórico de Empréstimos: " + historicoEmprestimos;
    }
}
