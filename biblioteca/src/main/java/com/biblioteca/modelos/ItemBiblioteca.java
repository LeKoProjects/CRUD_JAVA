package com.biblioteca.modelos;

public abstract class ItemBiblioteca {
    private String titulo;

    public ItemBiblioteca(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public abstract String exibirDetalhes();
}
