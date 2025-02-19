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
    private List<Departamento> departamentos = new ArrayList<>();

    @PostMapping
    public Funcionario createUser(@RequestBody Funcionario newUser) {
        funcionarios.add(newUser);
        return newUser;
    }


    @GetMapping("/{id}")
    @Operation(description = "Retorna o usuário com base no id")
    public ResponseEntity<Funcionario> getUsersById(@PathVariable int id) {
        try {
            Funcionario funcionario = funcionarios.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new FuncionarioNotFoundException("Usuário não encontrado"));

            return ResponseEntity.ok(funcionario);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> atualizarUsuario(@PathVariable("id") Integer id, @RequestBody Funcionario funAtualizado) {
        try {
            Funcionario funExistente = funcionarios.stream()
                    .filter(funcionario -> funcionario.getId() == id.intValue()) // comparação usando intValue()
                    .findFirst()
                    .orElseThrow(() -> new FuncionarioNotFoundException("Usuário não encontrado"));

            // Atualiza os dados do funcionário existente
            funExistente.setNome(funAtualizado.getNome());
            funExistente.setDepartamento(funAtualizado.getDepartamento());

            return ResponseEntity.ok(funExistente);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    //Departamento
    @PostMapping("/departamento")
    public Departamento createDep(@RequestBody Departamento newDep) {
        departamentos.add(newDep);
        return newDep;
    }

    @GetMapping("/funcionario/{id}")
    @Operation(description = "Retorna o usuário com base no id")
    public ResponseEntity<Departamento> getDepById(@PathVariable int id) {
        try {
            Departamento dep = departamentos.stream()
                    .filter(user -> user.getId() == id)
                    .findFirst()
                    .orElseThrow(() -> new FuncionarioNotFoundException("Departamento não encontrado"));

            return ResponseEntity.ok(dep);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    @PutMapping("/departamento/{id}")
    public ResponseEntity<Departamento> atualizarDep(@PathVariable("id") Integer id, @RequestBody Departamento depAtualizado) {
        try {
            Departamento depExistente = departamentos.stream()
                    .filter(departamento -> departamento.getId() == id.intValue()) // Correto: usar "departamento"
                    .findFirst()
                    .orElseThrow(() -> new FuncionarioNotFoundException("Departamento não encontrado"));

            // Atualiza os dados do departamento existente
            depExistente.setNome(depAtualizado.getNome());

            return ResponseEntity.ok(depExistente);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }



}

// Exceção personalizada
class FuncionarioNotFoundException extends RuntimeException {
    public FuncionarioNotFoundException(String message) {
        super(message);
    }

}
