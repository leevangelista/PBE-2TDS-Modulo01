package com.precisiontech.cp.controller;

import com.precisiontech.cp.entity.Turma;
import com.precisiontech.cp.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    private final TurmaRepository turmaRepository;

    @Autowired
    public TurmaController(TurmaRepository turmaRepository) {
        this.turmaRepository = turmaRepository;
    }

    // Create
    @PostMapping
    public ResponseEntity<Turma> criarTurma(@RequestBody Turma turma) {
        try {
            Turma novaTurma = turmaRepository.save(turma);
            return new ResponseEntity<>(novaTurma, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // Read all
    @GetMapping
    public ResponseEntity<List<Turma>> obterTodasTurmas() {
        List<Turma> turmas = turmaRepository.findAll();
        if (turmas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(turmas, HttpStatus.OK);
    }

    // Read one
    @GetMapping("/{id}")
    public ResponseEntity<Turma> obterTurmaPorId(@PathVariable("id") Long id) {
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        return turmaOptional.map(turma -> new ResponseEntity<>(turma, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // Update
    @PutMapping("/{id}")
    public ResponseEntity<Turma> atualizarTurma(@PathVariable("id") Long id, @RequestBody Turma turma) {
        Optional<Turma> turmaOptional = turmaRepository.findById(id);
        if (turmaOptional.isPresent()) {
            Turma _turma = turmaOptional.get();
            _turma.setCodTurma(turma.getCodTurma());
            _turma.setNome(turma.getNome());
            return new ResponseEntity<>(turmaRepository.save(_turma), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletarTurma(@PathVariable("id") Long id) {
        try {
            turmaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
