package com.example.Exerc7_JavaSpring;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamentos")

public class DepartController {

    private List<Departamento> departamentos = new ArrayList<>();

    @GetMapping
    public List<Departamento> getDepartamentos() {
        return departamentos;
    }

    @GetMapping("/{id}")
    @Operation(description = "Retorna o departamento com base no id")
    public  Departamento getDepartById(@PathVariable int id) {
        return departamentos.stream()
                .filter(departamento -> departamento.getIdDepartamento() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado."));
    }

    @PutMapping("/{id}")
    public  Departamento updateDepart(@PathVariable int id, @RequestBody Departamento depart) {
        Departamento updateDepart = departamentos.stream()
                .filter(departamento -> departamento.getIdDepartamento() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado."));

        updateDepart.setNomeDepartamento(depart.getNomeDepartamento());

        return updateDepart;
    }

    @PostMapping
    public Departamento createDepart(@RequestBody Departamento newDepart) {
        departamentos.add(newDepart);
        return  newDepart;
    }
}
