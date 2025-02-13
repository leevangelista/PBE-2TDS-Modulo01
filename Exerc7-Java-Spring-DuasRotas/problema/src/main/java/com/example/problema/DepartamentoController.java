package com.example.problema;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {
    private List<Departamento> deps = new ArrayList<>();
    @PostMapping
    public Departamento createDepartamento(@RequestBody Departamento newDepartamento){
        deps.add(newDepartamento);
        return newDepartamento;
    }
    @GetMapping("/{id}")
    public Departamento getDepartamentoById(@PathVariable int id){
        return deps.stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("usuário não encontrado"));
    }
    @GetMapping
    public List<Departamento> getDepartamento(){
        return deps;
    }

    @PutMapping("/{id}")
    public Departamento updateDepartamento(@PathVariable int id, @RequestBody Departamento departamento) {
        Departamento updateDepartamento = deps.stream()
                .filter(dep -> dep.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        updateDepartamento.setNome(departamento.getNome());
        return updateDepartamento;
    }
}

