package com.example.Exercicio10.controller;

import com.example.Exercicio10.banco.CursoBd;
import com.example.Exercicio10.model.Curso;

import java.util.List;

public class CursoController {
    CursoBd repository = new CursoBd();

    public List<Curso> getAll(){
        return repository.findAll();
    }

    public Curso getByIdCurso(Long idCurso) {
        return repository.getByIdCurso(idCurso);
    }
    public Curso getByNumeroSala(Integer numeroSala){
        return repository.getByNumeroSala(numeroSala);
    }

    public Curso getByNomeProfessor(String nomeProfessor){
        return repository.getByNomeProfessor(nomeProfessor);
    }

    public boolean insertBanco(Curso curso){
        return repository.insert(curso);
    }

    public  Curso update(Long idCurso, Curso curso ){
        boolean result = repository.update(idCurso, curso);

        if(result){
            return curso;
        }
        return null;
    }

    /*public Curso delete(Long idCurso){
        return repository.delete(idCurso);
    }*/

}
