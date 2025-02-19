package com.exercicio.ex7;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funcionarios")
public class appController {
    private List<Funcionario> funcionarios = new ArrayList<>();

    @GetMapping
    @Operation(description = "Retorna todos os usuários e seu departamento na lista")
    public List<Funcionario> getFuncionarios(){
        return funcionarios;
    }

    @GetMapping("/departamentos")
    @Operation(description = "Retorna todos os departamentos na lista")
    public List<Departamento> getDepartamentos(){
        return funcionarios.stream()
                .map(Funcionario::getDepartamento) //Mapeia
                .distinct() //Remove duplicatas
                .collect(Collectors.toList()); //Coleta como lista
    }

    @GetMapping("/{id}")
    @Operation(description = "Retorna o usuário com base no id")
    public Funcionario getFuncionarioById(@PathVariable int id){
        return funcionarios.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));
    }

    @GetMapping("/departamentos/{id}")
    @Operation(description = "Retorna o departamento com base no id")
    public Funcionario getDepartamentoById(@PathVariable int id){
        return funcionarios.stream()
                .filter(user -> user.departamento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));
    }

    @PostMapping
    @Operation(description = "Cria um usuário e adicionar na lista")
    public ResponseEntity<?> createUser(@RequestBody Funcionario newFuncionario){
        try {
            String nome = newFuncionario.getNome();

            boolean exists = funcionarios.stream()
                    .anyMatch(funcionario -> funcionario.getNome().equalsIgnoreCase(nome));
            //  Percorre cada funcionário da lista e aplica a função .getNome().equalsIgnoreCase(nome),
            //que compara o nome do funcionário atual com a variável nome, ignorando maiúsculas e minúsculas.
            //  A função anyMatch() retorna true se pelo menos um funcionário na lista tiver o mesmo nome.
            //  Se nenhum for encontrado, retorna false.

            if (exists) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body("Funcionário com este nome já existe!");
            }

            funcionarios.add(newFuncionario);
            return ResponseEntity.status(HttpStatus.CREATED).body(newFuncionario);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar funcionário.");
        }
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
