package com.precisiontech.cp.controller;

import com.precisiontech.cp.entity.MaoDeObra;
import com.precisiontech.cp.entity.Maquina;
import com.precisiontech.cp.repository.MaoDeObraRepository;
import com.precisiontech.cp.repository.MaquinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/maquinas")
public class MaquinaController {
    @Autowired
    private MaquinaRepository maquinaRepository;

    @GetMapping
    public List<Maquina> getAllMaquina() {
        return maquinaRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Maquina> getMaquinaById(@PathVariable Long id) {
        return maquinaRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Maquina> createMaquina(@RequestBody Maquina maquina) {
        Maquina savedMaquina = maquinaRepository.save(maquina);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMaquina);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Maquina> updateMaquina(@PathVariable Long id, @RequestBody Maquina updatedMaquina) {
        if (!maquinaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedMaquina.setId(id);
        Maquina savedMaquina = maquinaRepository.save(updatedMaquina);
        return ResponseEntity.ok(savedMaquina);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaquina(@PathVariable Long id) {
        if (!maquinaRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        maquinaRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
