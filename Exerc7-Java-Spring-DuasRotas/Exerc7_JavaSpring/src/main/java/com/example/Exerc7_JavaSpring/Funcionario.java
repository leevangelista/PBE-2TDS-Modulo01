package com.example.Exerc7_JavaSpring;

public class Funcionario extends  Departamento {

    // Atributos
    private int id;
    private String nome;

    public Funcionario(int id, String nome, int idDepartamento, String nomeDepartamento) {
        super(idDepartamento, nomeDepartamento);
        this.id = id;
        this.nome = nome;
    }

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
}
