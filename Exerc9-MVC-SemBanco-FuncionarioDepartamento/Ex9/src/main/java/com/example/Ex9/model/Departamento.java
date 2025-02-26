package com.example.Ex9.model;

import java.util.ArrayList;

public class Departamento {

    private Long id;
    private String nome;
    private ArrayList<Gerente> gerente;

    public Departamento(Long id, String nome, ArrayList<Gerente> gerente) {
        this.id = id;
        this.nome = nome;
        this.gerente = gerente;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Gerente> getGerente() {
        return gerente;
    }

    public void setGerente(ArrayList<Gerente> gerente) {
        this.gerente = gerente;
    }
}
