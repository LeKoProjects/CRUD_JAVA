package com.biblioteca.principal;

import com.biblioteca.modelos.Livro;
import com.biblioteca.servicos.LivroService;

import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LivroService livroService = new LivroService();

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Biblioteca");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Buscar Livro");
            System.out.println("4. Excluir Livro");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Título: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    System.out.print("Categoria: ");
                    String categoria = scanner.nextLine();
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    Livro novoLivro = new Livro(titulo, autor, categoria, isbn);
                    livroService.adicionarLivro(novoLivro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2:
                    System.out.println("\nLista de Livros:");
                    livroService.listarLivros().forEach(System.out::println);
                    break;
                case 3:
                    System.out.print("Título do Livro: ");
                    String buscaTitulo = scanner.nextLine();
                    Livro livro = livroService.buscarLivroPorTitulo(buscaTitulo);
                    System.out.println(livro != null ? livro : "Livro não encontrado.");
                    break;
                case 4:
                    System.out.print("Título do Livro para excluir: ");
                    String tituloExcluir = scanner.nextLine();
                    if (livroService.excluirLivro(tituloExcluir)) {
                        System.out.println("Livro excluído com sucesso!");
                    } else {
                        System.out.println("Livro não encontrado.");
                    }
                    break;
                case 5:
                    System.out.println("Encerrando o sistema.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }
}
