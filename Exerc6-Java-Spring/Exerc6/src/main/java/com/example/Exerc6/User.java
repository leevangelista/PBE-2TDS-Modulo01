package com.example.Exerc6;

public class User {

    private int id;
    private String nome;
    private String curso;

    public User(int id, String nome, String curso) {
        this.id = id;
        this.nome = nome;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
