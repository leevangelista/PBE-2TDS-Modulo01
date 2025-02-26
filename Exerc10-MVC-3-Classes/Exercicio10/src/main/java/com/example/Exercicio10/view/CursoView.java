package com.example.Exercicio10.view;

import com.example.Exercicio10.controller.CursoController;
import com.example.Exercicio10.model.Curso;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoView {
    CursoController cursoController = new CursoController();

    @GetMapping
    public List<Curso> getAll(@RequestParam(required = false)String nomeProfessor,
                              @RequestParam(required = false)Integer numeroSala) {

        if (numeroSala != null){
            return cursoController.getByNumeroSala(numeroSala);
        } else if (nomeProfessor != null) {
            return cursoController.getByNomeProfessor(nomeProfessor);
        }else {
            return cursoController.getAll();
        }
    }

    @GetMapping("/{idCurso}")
    public Curso getByIdCurso(@PathVariable Long idCurso) {
        return cursoController.getByIdCurso(idCurso);
    }



    @PostMapping
    public boolean insert(@RequestBody Curso Curso) {
        return cursoController.insertBanco(Curso);
    }

    @PutMapping("/{idCurso}")
    public Curso update(@RequestBody Curso curso, @PathVariable Long idCurso ) {
        return cursoController.update(idCurso, curso );
    }

}
