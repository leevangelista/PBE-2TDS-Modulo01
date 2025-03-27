package com.example.aula.Controller;

import com.example.aula.DTO.ProfessorDTO;
import com.example.aula.Entity.Professor;
import com.example.aula.Repository.ProfessorRepository;
import com.example.aula.Service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    private ProfessorService professorService;

    @PostMapping
    public ResponseEntity<ProfessorDTO> created(@RequestBody ProfessorDTO professorDTO){
        ProfessorDTO professorBd = professorService.save(professorDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(professorBd);
    }
}
