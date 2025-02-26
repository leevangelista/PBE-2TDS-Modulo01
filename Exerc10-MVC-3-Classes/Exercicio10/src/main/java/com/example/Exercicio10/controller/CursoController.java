package com.example.Exercicio10.controller;

import com.example.Exercicio10.model.Curso;

import java.util.List;

public class CursoController {
    CursoBd repository = new CursoBd();

    public List<Curso> getAll(){
        return repository.findAll();
    }

    public List<Curso> getBy

}
