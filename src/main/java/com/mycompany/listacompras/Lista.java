/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listacompras;

import java.util.ArrayList;

/**
 *
 * @author cauev
 */
public class Lista {
    private int id;
    private String nome;
    private ArrayList<Item> itens;

    public Lista(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }
    
    public String getNome() {
        return nome;
    
    }
    
    public ArrayList<Item> getItens() {
    return itens;
    }

    public int getId() {
        return id;
    }

    
    public void listarItens() {

    System.out.println("Lista: " + nome);

    for (Item item : itens) {

        System.out.println(
            "- " + item.getNome() +
            " | Quantidade: " + item.getQuantidade() +
            " | Status: " +
            (item.isComprado() ? "Comprado" : "Pendente")
        );
    }
    }
}