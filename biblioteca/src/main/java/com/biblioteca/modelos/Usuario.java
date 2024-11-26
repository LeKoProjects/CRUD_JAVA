package com.biblioteca.modelos;

import java.util.ArrayList;
import java.util.List;

public class Usuario extends Pessoa {
    private List<String> historicoEmprestimos;

    public Usuario(String nome, String endereco) {
        super(nome, endereco);
        this.historicoEmprestimos = new ArrayList<>();
    }

    public List<String> getHistoricoEmprestimos() {
        return historicoEmprestimos;
    }

    public void adicionarEmprestimo(String titulo) {
        historicoEmprestimos.add(titulo);
    }

    @Override
    public void exibirInformacoes() {
        super.exibirInformacoes();
        System.out.println("Histórico de Empréstimos: " + historicoEmprestimos);
    }
}
