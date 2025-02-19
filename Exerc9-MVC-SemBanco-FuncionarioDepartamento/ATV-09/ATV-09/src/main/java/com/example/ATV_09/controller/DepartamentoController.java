package com.example.ATV_09.controller;

import com.example.ATV_09.model.Departamento;
import com.example.ATV_09.model.Funcionario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/departamento")

public class DepartamentoController {
    private List<Departamento> departamentos = new ArrayList<>();
    @PostMapping
    public Departamento createUser(@RequestBody Departamento newUser) {
        departamentos.add(newUser);
        return newUser;
    }


    @GetMapping("/{id}")
    @Operation(description = "Retorna o usuário com base no id")
    public ResponseEntity<Departamento> getUsersById(@PathVariable int id) {
        try {
            Departamento departamento = departamentos.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new FuncionarioNotFoundException("Usuário não encontrado"));
            return ResponseEntity.ok(departamento);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @GetMapping
    public List<Departamento> getAllDep(){
        return departamentos;
    }
    @PutMapping("/{id}")
    public ResponseEntity<Departamento> atualizarUsuario(@PathVariable("id") Integer id, @RequestBody Departamento depAtualizado) {
        try {
            Departamento depExistente = departamentos.stream()
                    .filter(funcionario -> funcionario.getId() == id.intValue()) // comparação usando intValue()
                    .findFirst()
                    .orElseThrow(() -> new FuncionarioNotFoundException("Usuário não encontrado"));

            // Atualiza os dados do Departamento existente
            depExistente.setNome(depAtualizado.getNome());
            depExistente.setId(depAtualizado.getId());

            return ResponseEntity.ok(depExistente);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") int id) {
        Departamento departamento = departamentos.stream()
                .filter(func -> func.getId() == id)
                .findFirst()
                .orElse(null);

        if (departamento == null) {
            return ResponseEntity.status(404).build();
        }

        departamentos.remove(departamento);
        return ResponseEntity.noContent().build();
    }
}


