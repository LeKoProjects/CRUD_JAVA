package com.biblioteca.principal;

import com.biblioteca.modelos.Autor;
import com.biblioteca.modelos.ItemBiblioteca;
import com.biblioteca.modelos.Livro;
import com.biblioteca.modelos.Revista;
import com.biblioteca.modelos.Usuario;
import com.biblioteca.servicos.BibliotecaService;

import java.util.Scanner;

public class SistemaBiblioteca {
    public static void main(String[] args) {
        BibliotecaService bibliotecaService = new BibliotecaService();

        // testarPolimorfismo(bibliotecaService);
        // testarHeranca();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nSistema de Gerenciamento de Biblioteca");
            System.out.println("1. Adicionar Livro");
            System.out.println("2. Adicionar Revista");
            System.out.println("3. Listar Itens");
            System.out.println("4. Buscar Item por Título");
            System.out.println("5. Excluir Item");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Título do Livro: ");
                    String tituloLivro = scanner.nextLine();
                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();
                    bibliotecaService.adicionarItem(new Livro(tituloLivro, autor));
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Título da Revista: ");
                    String tituloRevista = scanner.nextLine();
                    System.out.print("Edição: ");
                    String edicao = scanner.nextLine();
                    bibliotecaService.adicionarItem(new Revista(tituloRevista, edicao));
                    System.out.println("Revista adicionada com sucesso!");
                    break;
                case 3:
                    System.out.println("\nItens da Biblioteca:");
                    bibliotecaService.listarItens().forEach(item -> item.exibirDetalhes());
                    break;
                case 4:
                    System.out.print("Título do Item: ");
                    String buscaTitulo = scanner.nextLine();
                    var item = bibliotecaService.buscarItemPorTitulo(buscaTitulo);
                    if (item != null) {
                        item.exibirDetalhes();
                    } else {
                        System.out.println("Item não encontrado!");
                    }
                    break;
                case 5:
                    System.out.print("Título do Item para excluir: ");
                    String tituloExcluir = scanner.nextLine();
                    if (bibliotecaService.excluirItem(tituloExcluir)) {
                        System.out.println("Item excluído com sucesso!");
                    } else {
                        System.out.println("Item não encontrado!");
                    }
                    break;
                case 6:
                    System.out.println("Encerrando o sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

        public static void testarPolimorfismo(BibliotecaService bibliotecaService) {
        System.out.println("\n--- Testando Polimorfismo ---");

        Livro livro = new Livro("Java Avançado", "James Gosling");
        bibliotecaService.adicionarItem(livro);

        Revista revista = new Revista("Tecnologia Hoje", "Edição Especial 2023");
        bibliotecaService.adicionarItem(revista);

        System.out.println("Itens na Biblioteca:");
        bibliotecaService.listarItens().forEach(ItemBiblioteca::exibirDetalhes);
    }

        public static void testarHeranca() {
        System.out.println("\n--- Testando Herança ---");

        Autor autor = new Autor("George Orwell", "Londres, Inglaterra", "25/06/1903");
        autor.exibirInformacoes();

        System.out.println();

        Usuario usuario = new Usuario("João Silva", "Rua das Flores, 123");
        usuario.adicionarEmprestimo("1984");
        usuario.adicionarEmprestimo("Revolução dos Bichos");
        usuario.exibirInformacoes();
    }
}
