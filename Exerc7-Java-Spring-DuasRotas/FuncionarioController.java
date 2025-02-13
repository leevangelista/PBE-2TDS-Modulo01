package com.example.empresa;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping

public class FuncionarioController {

    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<Funcionario> getAll(){
        return funcionarios;
    }

    @GetMapping("/{id}")
    public Funcionario getByiD(@PathVariable int id) {
        return funcionarios.stream()
                .filter( f -> f.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @PostMapping
    public Funcionario create (@RequestBody Funcionario Funcionario) {
        funcionarios.add(Funcionario);
        return Funcionario;
    }

    @PostMapping("/{id}")
    public Boolean update (@RequestBody Funcionario Funcionario, @PathVariable int getId){
        Funcionariouncionario fun = funcionario.stream()
                .filter( f -> f.getId() == id)
                .findFirst()
                .orElse(null);
        
    }






}


