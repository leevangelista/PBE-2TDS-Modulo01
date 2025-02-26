package com.example.Exercicio10.model;

import java.util.ArrayList;

public class Curso {
    private Long idCurso;
    private String nome;
    private int numeroSala;

    private ArrayList<Aluno> alunos = new ArrayList<>();

    private Professor professor;

    public Curso(Long idCurso, String nome, int numeroSala, ArrayList<Aluno> alunos, Professor professor) {
        this.idCurso = idCurso;
        this.nome = nome;
        this.numeroSala = numeroSala;
        this.alunos = alunos;
        this.professor = professor;
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public ArrayList<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(ArrayList<Aluno> alunos) {
        this.alunos = alunos;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }


}

