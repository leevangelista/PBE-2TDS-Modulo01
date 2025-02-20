package com.example.Ex9.Model;

public class Funcionario extends Departamento{

    private long id;
    private String nome;
    private String sobrenome;
    private String curso;
    private double salario;
    private Departamento departamento;

    public Funcionario(long id, String nome, String sobrenome, String curso, double salario, Departamento departamento) {
        super();
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.curso = curso;
        this.salario = salario;
        this.departamento = departamento;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
}
