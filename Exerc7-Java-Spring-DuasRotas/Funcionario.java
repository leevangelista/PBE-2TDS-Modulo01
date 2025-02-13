package com.example.empresa;


public class Funcionario {
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

    public com.example.empresa.departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(com.example.empresa.departamento departamento) {
        this.departamento = departamento;
    }

    private String nome;

    public Funcionario(int id, String nome, com.example.empresa.departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.departamento = departamento;
    }

    private com.example.empresa.departamento departamento;
}
