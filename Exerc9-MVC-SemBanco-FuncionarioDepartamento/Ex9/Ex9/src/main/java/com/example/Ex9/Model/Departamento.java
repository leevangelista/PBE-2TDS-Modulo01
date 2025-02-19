package com.example.Ex9.Model;

public class Departamento {

    private long id;
    private String nome;

    public Departamento(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }
    public Departamento() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
