package com.example.problema;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController{
    private List<Funcionario> funs = new ArrayList<>();
    @PostMapping
    public Funcionario createFuncionario(@RequestBody Funcionario newFuncionario){
        funs.add(newFuncionario);
        return newFuncionario;
    }
    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable int id){
        return funs.stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    @GetMapping
    public List<Funcionario> getFuncionario(){
        return funs;
    }

    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable int id, @RequestBody Funcionario funcionario) {
        Funcionario updateFuncionario = funs.stream()
                .filter(fun -> fun.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));
        updateFuncionario.setNome(funcionario.getNome());
        updateFuncionario.setDepartamento(funcionario.getDepartamento());

        return updateFuncionario;
    }
}

