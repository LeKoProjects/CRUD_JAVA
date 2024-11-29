package com.biblioteca.servicos;

import com.biblioteca.modelos.ItemBiblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaService {
    private List<ItemBiblioteca> itens = new ArrayList<>();

    public void adicionarItem(ItemBiblioteca item) {
        itens.add(item);
    }

    public List<ItemBiblioteca> listarItens() {
        return itens;
    }

    public ItemBiblioteca buscarItemPorTitulo(String titulo) {
        return itens.stream()
                    .filter(item -> item.getTitulo().equalsIgnoreCase(titulo))
                    .findFirst()
                    .orElse(null);
    }

    public boolean excluirItem(String titulo) {
        ItemBiblioteca item = buscarItemPorTitulo(titulo);
        if (item != null) {
            itens.remove(item);
            return true;
        }
        return false;
    }
}
