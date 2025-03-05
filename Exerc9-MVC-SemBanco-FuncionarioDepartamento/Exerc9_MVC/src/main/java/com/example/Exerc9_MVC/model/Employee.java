package com.example.Exerc9_MVC.model;

public class Employee {
    // Attributes
    private Long id;
    private String nome;
    private String sobrenome;
    private String curso;
    private double salario;
    private Department department;

    // Constructor
    public Employee(Long id, String nome, String sobrenome, String curso, double salario, Department department) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.curso = curso;
        this.salario = salario;
        this.department = department;
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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
