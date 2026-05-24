/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.listacompras;

/**
 *
 * @author cauev
 */
public class Item {

    private int id;
    private String nome;
    private int quantidade;
    private String marcaFornecedor;
    private boolean comprado;

    public Item(int id, String nome, int quantidade, String marcaFornecedor) {

        this.id = id;
        this.nome = nome;
        this.quantidade = quantidade;
        this.marcaFornecedor = marcaFornecedor;

        this.comprado = false;
    }

    public boolean isComprado() {
        return comprado;
    }

    public void setComprado(boolean comprado) {
        this.comprado = comprado;
    }

    public void marcarComoComprado() {
        comprado = true;
    }

    public String getNome() {
        return nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getMarcaFornecedor() {
        return marcaFornecedor;
    }

    public int getId() {
        return id;
    }
}
