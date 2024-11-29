package com.biblioteca.views;

import com.biblioteca.modelos.*;
import com.biblioteca.servicos.BibliotecaService;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class BibliotecaUI extends Application {
    private BibliotecaService bibliotecaService = new BibliotecaService();

    @Override
    public void start(Stage stage) {
        VBox layout = new VBox(10);
        layout.setPadding(new Insets(10));

        Label titulo = new Label("Sistema de Gerenciamento de Biblioteca");
        titulo.setStyle("-fx-font-size: 16px; -fx-font-weight: bold;");

        Button btnAdicionarLivro = new Button("Adicionar Livro");
        Button btnAdicionarRevista = new Button("Adicionar Revista");
        Button btnListarItens = new Button("Listar Itens");
        Button btnExcluirItem = new Button("Excluir Item");
        Button btnVisualizarHeranca = new Button("Visualizar Herança");
        Button btnVisualizarPolimorfismo = new Button("Visualizar Polimorfismo");

        TextArea areaSaida = new TextArea();
        areaSaida.setEditable(false);
        areaSaida.setPrefHeight(300);

        btnAdicionarLivro.setOnAction(e -> adicionarLivro(areaSaida));
        btnAdicionarRevista.setOnAction(e -> adicionarRevista(areaSaida));
        btnListarItens.setOnAction(e -> listarItens(areaSaida));
        btnExcluirItem.setOnAction(e -> excluirItem(areaSaida));
        btnVisualizarHeranca.setOnAction(e -> testarHeranca(areaSaida));
        btnVisualizarPolimorfismo.setOnAction(e -> testarPolimorfismo(areaSaida));

        layout.getChildren().addAll(titulo, btnAdicionarLivro, btnAdicionarRevista, btnListarItens, btnExcluirItem, btnVisualizarHeranca, btnVisualizarPolimorfismo, areaSaida);

        Scene scene = new Scene(layout, 600, 600);
        stage.setScene(scene);
        stage.setTitle("Sistema Biblioteca");
        stage.show();
    }

    private void adicionarLivro(TextArea areaSaida) {
        Dialog<String[]> dialog = new Dialog<>();
        dialog.setTitle("Adicionar Livro");
    
        TextField campoTitulo = new TextField();
        TextField campoAutor = new TextField();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Título:"), 0, 0);
        grid.add(campoTitulo, 1, 0);
        grid.add(new Label("Autor:"), 0, 1);
        grid.add(campoAutor, 1, 1);
    
        dialog.getDialogPane().setContent(grid);
        ButtonType confirmar = new ButtonType("Adicionar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(confirmar, ButtonType.CANCEL);
    
        dialog.setResultConverter(button -> {
            if (button == confirmar) {
                return new String[]{campoTitulo.getText(), campoAutor.getText()};
            }
            return null;
        });
    
        dialog.showAndWait().ifPresent(resultado -> {
            Livro livro = new Livro(resultado[0], resultado[1]);
            bibliotecaService.adicionarItem(livro);
            areaSaida.appendText("Livro adicionado: " + resultado[0] + "\n");
        });
    }
    

    private void adicionarRevista(TextArea areaSaida) {
        Dialog<String[]> dialog = new Dialog<>();
        dialog.setTitle("Adicionar Revista");
    
        TextField campoTitulo = new TextField();
        TextField campoEdicao = new TextField();
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));
        grid.add(new Label("Título:"), 0, 0);
        grid.add(campoTitulo, 1, 0);
        grid.add(new Label("Edição:"), 0, 1);
        grid.add(campoEdicao, 1, 1);
    
        dialog.getDialogPane().setContent(grid);
        ButtonType confirmar = new ButtonType("Adicionar", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(confirmar, ButtonType.CANCEL);
    
        dialog.setResultConverter(button -> {
            if (button == confirmar) {
                return new String[]{campoTitulo.getText(), campoEdicao.getText()};
            }
            return null;
        });
    
        dialog.showAndWait().ifPresent(resultado -> {
            Revista revista = new Revista(resultado[0], resultado[1]);
            bibliotecaService.adicionarItem(revista);
            areaSaida.appendText("Revista adicionada: " + resultado[0] + "\n");
        });
    }    

    private void listarItens(TextArea areaSaida) {
        areaSaida.clear();
        bibliotecaService.listarItens().forEach(item -> areaSaida.appendText(item.exibirDetalhes() + "\n"));
    }

    private void excluirItem(TextArea areaSaida) {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Excluir Item");
        dialog.setHeaderText("Digite o título do item para excluir:");
        dialog.setContentText("Título:");

        dialog.showAndWait().ifPresent(titulo -> {
            if (bibliotecaService.excluirItem(titulo)) {
                areaSaida.appendText("Item excluído: " + titulo + "\n");
            } else {
                areaSaida.appendText("Item não encontrado: " + titulo + "\n");
            }
        });
    }

    private void testarHeranca(TextArea areaSaida) {
        areaSaida.clear();
    
        Dialog<String[]> dialogAutor = new Dialog<>();
        dialogAutor.setTitle("Adicionar Autor");
        GridPane gridAutor = new GridPane();
        gridAutor.setHgap(10);
        gridAutor.setVgap(10);
        gridAutor.setPadding(new Insets(20, 150, 10, 10));
    
        TextField nomeAutor = new TextField();
        TextField enderecoAutor = new TextField();
        TextField dataNascimento = new TextField();
        gridAutor.add(new Label("Nome:"), 0, 0);
        gridAutor.add(nomeAutor, 1, 0);
        gridAutor.add(new Label("Endereço:"), 0, 1);
        gridAutor.add(enderecoAutor, 1, 1);
        gridAutor.add(new Label("Data de Nascimento:"), 0, 2);
        gridAutor.add(dataNascimento, 1, 2);
    
        dialogAutor.getDialogPane().setContent(gridAutor);
        ButtonType confirmarAutor = new ButtonType("Adicionar", ButtonBar.ButtonData.OK_DONE);
        dialogAutor.getDialogPane().getButtonTypes().addAll(confirmarAutor, ButtonType.CANCEL);
    
        dialogAutor.setResultConverter(dialogButton -> {
            if (dialogButton == confirmarAutor) {
                return new String[]{nomeAutor.getText(), enderecoAutor.getText(), dataNascimento.getText()};
            }
            return null;
        });
    
        dialogAutor.showAndWait().ifPresent(resultado -> {
            Autor autor = new Autor(resultado[0], resultado[1], resultado[2]);
            areaSaida.appendText("Autor Adicionado:\n" + autor.exibirInformacoes() + "\n");
        });
    
        Dialog<String[]> dialogUsuario = new Dialog<>();
        dialogUsuario.setTitle("Adicionar Usuário");
        GridPane gridUsuario = new GridPane();
        gridUsuario.setHgap(10);
        gridUsuario.setVgap(10);
        gridUsuario.setPadding(new Insets(20, 150, 10, 10));
    
        TextField nomeUsuario = new TextField();
        TextField enderecoUsuario = new TextField();
        gridUsuario.add(new Label("Nome:"), 0, 0);
        gridUsuario.add(nomeUsuario, 1, 0);
        gridUsuario.add(new Label("Endereço:"), 0, 1);
        gridUsuario.add(enderecoUsuario, 1, 1);
    
        dialogUsuario.getDialogPane().setContent(gridUsuario);
        ButtonType confirmarUsuario = new ButtonType("Adicionar", ButtonBar.ButtonData.OK_DONE);
        dialogUsuario.getDialogPane().getButtonTypes().addAll(confirmarUsuario, ButtonType.CANCEL);
    
        dialogUsuario.setResultConverter(dialogButton -> {
            if (dialogButton == confirmarUsuario) {
                return new String[]{nomeUsuario.getText(), enderecoUsuario.getText()};
            }
            return null;
        });
    
        dialogUsuario.showAndWait().ifPresent(resultado -> {
            Usuario usuario = new Usuario(resultado[0], resultado[1]);
            usuario.adicionarEmprestimo("1984");
            usuario.adicionarEmprestimo("Revolução dos Bichos");
            areaSaida.appendText("Usuário Adicionado:\n" + usuario.exibirInformacoes() + "\n");
        });
    }
    

    private void testarPolimorfismo(TextArea areaSaida) {
        areaSaida.clear();
    
        if (bibliotecaService.listarItens().isEmpty()) {
            areaSaida.appendText("Nenhum item disponível na biblioteca para demonstrar polimorfismo.\n");
            return;
        }
    
        areaSaida.appendText("Demonstrando Polimorfismo:\n");
        bibliotecaService.listarItens().forEach(item -> areaSaida.appendText(item.exibirDetalhes() + "\n"));
    }
    
}
