package com.precisiontech.cp.controller;


import com.precisiontech.cp.entity.MaoDeObra;
import com.precisiontech.cp.entity.Material;
import com.precisiontech.cp.repository.MaterialRepository;
import com.precisiontech.cp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping
    public ResponseEntity<List<Material>> getAllMaterial() {
        try {
            List<Material> materials = materialRepository.findAll();
            if (!materials.isEmpty()) {
                return ResponseEntity.ok(materials);
            } else {
                return ResponseEntity.noContent().build(); // Retorna 204 No Content se a lista estiver vazia
            }

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build(); // Retorna 500 Internal Server Error se ocorrer uma exceção
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Material> getMaterialById(@PathVariable Long id) {
        return materialRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<Material> createMaterial(@RequestBody Material material) {
        Material savedMaterial = materialRepository.save(material);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedMaterial);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Material> updateMaterial(@PathVariable Long id, @RequestBody Material updatedMaterial) {
        if (!materialRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        updatedMaterial.setId(id);
        Material savedMaterial = materialRepository.save(updatedMaterial);
        return ResponseEntity.ok(savedMaterial);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMaterial(@PathVariable Long id) {
        if (!materialRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        materialRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}