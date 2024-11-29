package com.biblioteca.principal;

import com.biblioteca.views.BibliotecaUI;
import javafx.application.Application;
import javafx.stage.Stage;

public class SistemaBiblioteca extends Application {
    @Override
    public void start(Stage stage) {
        BibliotecaUI bibliotecaUI = new BibliotecaUI();
        bibliotecaUI.start(stage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
