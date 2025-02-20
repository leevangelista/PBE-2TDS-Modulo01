package com.precisiontech.cp.controller;

import com.precisiontech.cp.entity.MaoDeObra;
import com.precisiontech.cp.repository.MaoDeObraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/maodeobra")
public class MaoDeObraController {

    @Autowired
    private MaoDeObraRepository maoDeObraRepository;

    @GetMapping
    public List<MaoDeObra> getAllMaoDeObra() {
        return maoDeObraRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MaoDeObra> getMaoDeObraById(@PathVariable Long id) {
        return maoDeObraRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<MaoDeObra> createMaoDeObra(@RequestBody MaoDeObra maoDeObra) {
        System.out.println(maoDeObra);
        MaoDeObra savedMaoDeObra = maoDeObraRepository.save(maoDeObra);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMaoDeObra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MaoDeObra> updateMaoDeObra(@PathVariable Long id, @RequestBody MaoDeObra updatedMaoDeObra) {
        if (!maoDeObraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedMaoDeObra.setId(id);
        MaoDeObra savedMaoDeObra = maoDeObraRepository.save(updatedMaoDeObra);
        return ResponseEntity.ok(savedMaoDeObra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaoDeObra(@PathVariable Long id) {
        if (!maoDeObraRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        maoDeObraRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
