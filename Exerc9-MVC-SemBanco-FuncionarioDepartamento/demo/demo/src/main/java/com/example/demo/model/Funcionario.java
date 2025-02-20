package com.example.demo.model;

public class Funcionario {
    private Long id;
    private String nome;
    private String sobrenome;
    private double salario;
    private String curso;
    private Departamento departamento;

    public Funcionario(Long id, String nome, String sobrenome, double salario, String curso, Departamento departamento) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.salario = salario;
        this.curso = curso;
        this.departamento = departamento;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
