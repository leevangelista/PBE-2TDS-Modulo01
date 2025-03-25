package com.example.Exerc7_JavaSpring;

public class Departamento {

    // Atributos
    private int idDepartamento;
    private  String nomeDepartamento;

    public Departamento(int idDepartamento, String nomeDepartamento) {
        this.idDepartamento = idDepartamento;
        this.nomeDepartamento = nomeDepartamento;
    }

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNomeDepartamento() {
        return nomeDepartamento;
    }

    public void setNomeDepartamento(String getNomeDepartamento) {
        this.nomeDepartamento = nomeDepartamento;
    }
}
