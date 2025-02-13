package com.example.empresa;
public class departamento {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    private String nome;

    public departamento(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
