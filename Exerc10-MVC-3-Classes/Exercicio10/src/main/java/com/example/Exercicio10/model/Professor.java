package com.example.Exercicio10.model;

public class Professor {
    private Long idProfessor;
    private String nomeProfessor;
    private String cpf;

    private double salario;

    public Professor(Long idProfessor, String nomeProfessor, String cpf, double salario) {
        this.idProfessor = idProfessor;
        this.nomeProfessor = Professor.this.nomeProfessor;
        this.cpf = cpf;
        this.salario = salario;
    }

    public Long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(Long idProfessor) {
        this.idProfessor = idProfessor;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }

    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = Professor.this.nomeProfessor;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
