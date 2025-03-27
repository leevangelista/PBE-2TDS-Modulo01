package com.example.atv27_03.Controller;


import com.example.atv27_03.DTO.ProfessorDTO;
import com.example.atv27_03.Entity.Professor;
import com.example.atv27_03.Service.ProfessorService;
import com.example.atv27_03.DTO.ProfessorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private ProfessorService professorService;

    @GetMapping
    public ResponseEntity<List<Professor>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(professorService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfessorDTO> getById(@PathVariable Long id){
        Optional<ProfessorDTO> professorDTO = professorService.getById(id);
        if(professorDTO.isPresent()){
            return ResponseEntity.ok(professorDTO.get());
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

//        return professorDTO.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProfessorDTO> created(@RequestBody ProfessorDTO professorDto){
        ProfessorDTO professor = professorService.save(professorDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(professor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProfessorDTO> update(@PathVariable Long id, @RequestBody ProfessorDTO professorDTO){
        Optional<ProfessorDTO> professorDTOOptional = professorService.updateProfessor(id, professorDTO);
        if (professorDTOOptional.isPresent()){
            return ResponseEntity.ok(professorDTOOptional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if(professorService.delete(id)){
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
