package com.biblioteca.servicos;

import com.biblioteca.modelos.Livro;

import java.util.ArrayList;
import java.util.List;

public class LivroService {
    private List<Livro> livros = new ArrayList<>();

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public List<Livro> listarLivros() {
        return livros;
    }

    public Livro buscarLivroPorTitulo(String titulo) {
        return livros.stream()
                     .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                     .findFirst()
                     .orElse(null);
    }

    public boolean excluirLivro(String titulo) {
        Livro livro = buscarLivroPorTitulo(titulo);
        if (livro != null) {
            livros.remove(livro);
            return true;
        }
        return false;
    }
}
