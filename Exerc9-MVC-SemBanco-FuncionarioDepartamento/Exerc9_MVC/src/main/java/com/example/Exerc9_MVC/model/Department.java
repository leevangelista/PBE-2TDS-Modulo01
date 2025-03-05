package com.example.Exerc9_MVC.model;

public class Department {
    // Attributes
    private Long id;
    private String nome;

    // Constructor
    public Department(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    // Getters and Setters
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
}
