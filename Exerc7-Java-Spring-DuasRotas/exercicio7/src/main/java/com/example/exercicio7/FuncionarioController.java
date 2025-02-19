package com.example.exercicio7;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/funcionario")

public class FuncionarioController {

    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<Funcionario> getFuncionario(){
        return funcionarios;
    }

    @GetMapping("/{id}")
    public Funcionario getFuncionarioById(@PathVariable int id){
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    @PostMapping
    public Funcionario creatFuncionario(@RequestBody Funcionario newFuncionario){
        funcionarios.add(newFuncionario);
        return newFuncionario;
    }

    @PutMapping("/{id}")
    public Funcionario atualizarFuncionario(@PathVariable int id, @RequestBody Funcionario newFuncionario){
        Funcionario trabalador = funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));

        if (id >= 0){
            trabalador.setNome(newFuncionario.getNome());
            trabalador.setDepartamento(newFuncionario.getDepartamento());
        }
        else {
            System.out.println("Id invalido");
        }
        return trabalador;
    }
}
