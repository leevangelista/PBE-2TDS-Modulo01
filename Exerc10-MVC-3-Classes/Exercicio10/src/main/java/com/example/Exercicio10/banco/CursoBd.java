package com.example.Exercicio10.banco;

import com.example.Exercicio10.model.Curso;
import com.example.Exercicio10.model.Professor;

import java.util.ArrayList;
import java.util.List;

public class  CursoBd {
    private List<Curso> cursos;

    public CursoBd(){
        this.cursos = new ArrayList<>();
    }

    //buscar todos os cursos
    public List<Curso> findAll(){
        return new ArrayList<>(cursos);
    }

    //busca um curso pelo nome do professor
    public Curso getByNomeProfessor(String nomeProfessor){
        return cursos.stream()
                .filter(curso -> curso.getProfessor().getNomeProfessor().equals(nomeProfessor))
                .findFirst()
                .orElse(null);

    }
    //busca um curso pelo numero de sala
    public Curso getByNumeroSala(Integer numeroSala){
        return cursos.stream()
                .filter()
                .findFirst()
                .orElse(null);

    }

    //busca um curso pelo id
    public Curso getByIdCurso(Long idCurso){
        return cursos.stream()
                .filter(f -> f.getIdCurso() == idCurso)
                .findFirst()
                .orElse(null);
    }

    //insere um curso
    public boolean insert(Curso curso){
        cursos.add(curso);
        return true;
    }

    //atualiza um curso pelo id
    public boolean update(Long idCurso, Curso curso){
        Curso cursoBd = cursos.stream()
                .filter(b -> b.getIdCurso() == idCurso)
                .findFirst()
                .orElse(null);
        if (cursoBd == null){
            return false;
        }
        cursoBd.setNome(curso.getNome());

        return true;
    }

    //deleta um curso pelo id

    public boolean delete(Long idCurso){
        Curso cursoBd = cursos.stream()
                .filter(d -> d.getIdCurso() == idCurso)
                .findFirst()
                .orElse(null);
        if (cursoBd == null){
            return false;
        }

        cursos.remove(cursoBd);
        return  true;
    }
}
