package com.example.atv9.controller;

import com.example.atv9.model.Departamento;
import com.example.atv9.model.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping ("/funcionario")
public class FuncionarioController {

    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    public List<Funcionario> getAllUsers() {
        return funcionarios;
    }

    @GetMapping("funcionario/{curso}")
    @Operation(description = "Primeiro retorno")
    public ResponseEntity<?> getUserByCurso(@RequestParam String curso) {
        try {
            Funcionario funcionario = funcionarios.stream()
                    .filter(user -> user.getCurso().equals(curso))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
            return ResponseEntity.ok(funcionario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/{departamento}")
    @Operation(description = "Primeiro retorno")
    public ResponseEntity<?> getUserByDepartamento(@PathVariable String departamento) {
        try {
            Funcionario funcionario = funcionarios.stream()
                    .filter(user -> user.getCurso().equalsIgnoreCase(departamento)) // Comparação segura para Strings
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));

            return ResponseEntity.ok(funcionario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }



    @GetMapping("/{salário}")
    @Operation (description = "Primeiro retorno")
    public Funcionario getUserById(@PathVariable double salario) {
        return funcionarios.stream()
                .filter(funcionario -> funcionario.getSalario() == salario)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
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
