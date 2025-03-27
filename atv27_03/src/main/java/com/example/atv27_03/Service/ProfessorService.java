package com.example.aula.Service;

import com.example.aula.DTO.ProfessorDTO;
import com.example.aula.Entity.Professor;
import com.example.aula.Repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public Professor fromDTO(ProfessorDTO professorDTO){
        Professor professor = new Professor();
        professor.setNome(professorDTO.getNome());
        professor.setCpf(professorDTO.getCpf());

        return professor;
    }

    public ProfessorDTO toDTO(Professor professor){
        ProfessorDTO professorDTO = new ProfessorDTO();
        ProfessorDTO.setId(professor.getIdProfessor());
        ProfessorDTO.setNome(professor.getNome());
        ProfessorDTO.setCpf(professor.getCpf());

        return professorDTO;

    }

    public Professor save(ProfessorDTO professorDTO){
        Professor professor = this.fromDTO(professorDTO);
        Professor professorBd = professorRepository.save(professor);
        return professorBd;
    }
}
