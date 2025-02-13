package com.example.problema;

public class Funcionario extends Departamento {
    private int id;
    private String nome;
    Departamento departamento;

    public Funcionario(int id, String nome, int id1, String nome1, Departamento departamento) {
        super(id, nome);
        this.id = id1;
        this.nome = nome1;
        this.departamento = departamento;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public void setNome(String nome) {
        this.nome = nome;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
