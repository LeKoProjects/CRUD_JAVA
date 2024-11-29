package com.biblioteca.modelos;

public class Revista extends ItemBiblioteca {
    private String edicao;

    public Revista(String titulo, String edicao) {
        super(titulo);
        this.edicao = edicao;
    }

    public String getEdicao() {
        return edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    @Override
    public String exibirDetalhes() {
        return "Revista: " + getTitulo() + " | Edição: " + edicao;
    }
}
