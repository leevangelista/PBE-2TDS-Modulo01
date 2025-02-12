package com.exercicio.ex7;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionarios")
public class appController {
    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    @Operation(description = "Retorna todos os usuários na lista")
    public List<Funcionario> getFuncionarios(){
        return funcionarios;
    }

    @GetMapping("/{id}")
    @Operation(description = "Retorna o usuário com base no id")
    public Funcionario getFuncionarioById(@PathVariable int id){
        return funcionarios.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    @PostMapping
    @Operation(description = "Cria um usuário e adicionar na lista")
    public Funcionario createUser(@RequestBody Funcionario newFuncionario){
        funcionarios.add(newFuncionario);
        return newFuncionario;
    }

    @PutMapping("/{id}")
    @Operation(description = "Atualiza os dados do usuário identificado pelo ID")
    public ResponseEntity<Funcionario> updateUser(@RequestBody Funcionario funcionario, @PathVariable int id){
        Funcionario existeFuncionario = funcionarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .orElse(null);

        if (existeFuncionario == null) {
            return ResponseEntity.notFound().build();
        }

        existeFuncionario.setNome(funcionario.getNome());

        return ResponseEntity.ok(existeFuncionario);
    }
    @PutMapping("/departamento/{id}")
    @Operation(description = "Atualiza os dados do departamento identificado pelo ID")
    public ResponseEntity<Funcionario> updateDep(@RequestBody Departamento departamento, @PathVariable int id){
        Funcionario existeDepartamento = funcionarios.stream()
                .filter(usuario -> usuario.getDepartamento().getId() == id)
                .findFirst()
                .orElse(null);

        if (existeDepartamento == null) {
            return ResponseEntity.notFound().build();
        }

        existeDepartamento.departamento.setNome(departamento.getNome());

        return ResponseEntity.ok(existeDepartamento);
    }
}
