package com.example.aula07;

import com.example.aula07.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class UserController {

    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<Funcionario> getAllUsers() {
        return funcionarios;
    }

    @GetMapping("/{id}")
    @Operation(description = "Primeiro retorno")
    public Funcionario getUserById(@PathVariable int id) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    @PostMapping
    public Funcionario createUser(@RequestBody Funcionario newUser) {
        funcionarios.add(newUser);
        return newUser;
    }

    @PutMapping("/{id}")
    public Funcionario updateFuncionario(@PathVariable int id, @RequestBody Funcionario updatedFuncionario) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .map(existingFuncionario -> {
                    existingFuncionario.setNome(updatedFuncionario.getNome());

                    return existingFuncionario;
                })
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));

    }
}

