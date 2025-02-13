package com.example.aula07;
import com.example.aula07.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class UserControllerDep {

    private List<Departamento> departamentos = new ArrayList<>();

    @GetMapping
    public List<Departamento> getAllUsers() {
        return departamentos;
    }

    @GetMapping("/{id}")
    @Operation(description = "Primeiro retorno")
    public Departamento getDepartamentoById(@PathVariable Long id) {
        return departamentos.stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado!"));
    }

    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento departamento) {
        departamentos.add(departamento);
        return departamento;
    }

    @PutMapping("/{id}")
    public Departamento updateDepartamento(@PathVariable int id, @RequestBody Departamento updatedDepartamento) {
        return departamentos.stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .map(existingDepartamento -> {
                    existingDepartamento.setNome(updatedDepartamento.getNome());
                    return existingDepartamento;
                })
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado!"));
    }
}


