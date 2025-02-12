package com.example.Exerc7_JavaSpring;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")

public class Controller {

    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    @GetMapping("/{id}")
    // @Operation(description = "Retorna o funcionário com base no id")
    public  Funcionario getFuncByID(@PathVariable int id) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));
    }

    @PutMapping("/{id}")
    public Funcionario updateFunc(@PathVariable int id, @RequestBody Funcionario func) {
        Funcionario updateFunc = funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado."));

        updateFunc.setNome(func.getNome());
        updateFunc.setNomeDepartamento(func.getNomeDepartamento());
        updateFunc.setIdDepartamento(func.getIdDepartamento());

        return updateFunc;
    }
}
