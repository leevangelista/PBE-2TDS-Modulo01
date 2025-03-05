package com.example.Curso.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {
    private int idCurso;
    private String nome;
    private int numeroSala;
    private ArrayList<Aluno> alunos;
    private Professor professor;
}
