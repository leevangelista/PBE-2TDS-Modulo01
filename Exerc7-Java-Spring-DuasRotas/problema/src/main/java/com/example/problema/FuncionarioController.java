package com.example.problema;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController{
    private List<Funcionario> funcionarios = new ArrayList<>();
    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario newFuncionario){
        funcionarios.add(newFuncionario);
        return newFuncionario;
    }
    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable long id){
        return funcionarios.stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
    }
    @GetMapping
    public List<Funcionario> getFuncionario(){
        return funcionarios;
    }

    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable long id, @RequestBody Funcionario funcionario) {
        Funcionario updateFuncionario = funcionarios.stream()
                .filter(fun -> fun.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        updateFuncionario.setNome(funcionario.getNome());
        updateFuncionario.setDepartamento(funcionario.getDepartamento());

        return updateFuncionario;
    }
}

