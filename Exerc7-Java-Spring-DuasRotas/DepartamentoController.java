package com.example.empresa;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/departamento")
public class DepartamentoController {

    private List<departamento> departamentos = new ArrayList<>();

    @GetMapping
    public List<departamento> getAll(){
        return departamentos;
    }

    @GetMapping("/{id}")
    public departamento getByiD(@PathVariable int id) {
        return departamentos.stream()
                .filter( d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public departamento create (@RequestBody departamento departamento) {
        departamentos.add(departamento);
        return departamento;
    }

    @PostMapping("/{id}")
    public Boolean update (@RequestBody departamento departamento, @PathVariable int getId){
        departamento dep = departamentos.stream()
                .filter( d -> d.getId() == id)
                .findFirst()
                .orElse(null);

    }






}
