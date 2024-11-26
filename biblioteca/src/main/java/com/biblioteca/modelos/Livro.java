package com.biblioteca.modelos;

public class Livro extends ItemBiblioteca {
    private String autor;

    public Livro(String titulo, String autor) {
        super(titulo);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Livro: " + getTitulo() + " | Autor: " + autor);
    }
}
