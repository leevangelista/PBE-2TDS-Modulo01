package com.example.atv07;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class UserController {
    private List<Funcionario> funcionarios = new ArrayList<>();
    @PostMapping
    public Funcionario createUser(@RequestBody Funcionario newUser){
        funcionarios.add(newUser);
        return newUser;
    }

    @GetMapping
    public List<Funcionario> getUser(){
        return funcionarios;
    }
    @GetMapping("/{id}")
    @Operation(description =  "Retorna o usuário com base no id")
    public Funcionario getUsersById(@PathVariable int id){
        return funcionarios.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarUsuario(@PathVariable("id") Integer id, @RequestBody Funcionario funAtualizado) {
        Funcionario funExistente = funcionarios.get(id);

        if (funExistente == null) {
            return ResponseEntity.notFound().build();
        }
        funExistente.setId(funExistente.getId());
        funExistente.setNome(funAtualizado.getNome());
        funExistente.setDepartamento(funAtualizado.getDepartamento());

        return ResponseEntity.ok(funExistente);
    }
}
