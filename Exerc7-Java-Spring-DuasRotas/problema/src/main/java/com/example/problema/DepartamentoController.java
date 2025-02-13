package com.example.problema;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private List<Departamento> departamentos = new ArrayList<>();

    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento newDepartamento){
        departamentos.add(newDepartamento);
        return newDepartamento;
    }

    @GetMapping("/{id}")
    public Departamento getDepartamentoById(@PathVariable long id){
        return departamentos.stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
    }

    @GetMapping
    public List<Departamento> getDepartamento(){
        return departamentos;
    }

    @PutMapping("/{id}")
    public Departamento updateDepartamento(@PathVariable long id, @RequestBody Departamento departamento) {
        Departamento updateDepartamento = departamentos.stream()
                .filter(dep -> dep.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        updateDepartamento.setNome(departamento.getNome());
        return updateDepartamento;
    }
}

