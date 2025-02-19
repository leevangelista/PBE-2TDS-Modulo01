package com.example.ATV_09.controller;

import com.example.ATV_09.model.Departamento;
import com.example.ATV_09.model.Funcionario;
import com.example.ATV_09.banco.FuncionarioBd;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    List<Funcionario> funcionarios = new ArrayList<>();
    FuncionarioBd repository = new FuncionarioBd();// teste

    @PostMapping
    public Funcionario createUser(@RequestBody Funcionario newUser) {
        funcionarios.add(newUser);
        return newUser;
    }

    public List<Funcionario> getAll(){
        return repository.findAll();
    } // teste

    @GetMapping("/todos")
    public List<Funcionario> getAllFun(){
        return funcionarios;
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
    // novos Gets
    @GetMapping("funcionario/{curso}")
    @Operation(description = "Retorna o usuário com base no curso")
    public ResponseEntity<Funcionario> getUsersByCurso(@RequestParam String curso) {
        try {
            Funcionario funcionario = funcionarios.stream()
                    .filter(user -> user.getCurso().equals(curso))
                    .findFirst()
                    .orElseThrow(() -> new FuncionarioNotFoundException("Usuário não encontrado"));
            return ResponseEntity.ok(funcionario);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/departamento")  // Usando um caminho fixo para o endpoint de departamento
    @Operation(description = "Retorna o usuário com base no Departamento")
    public ResponseEntity<Funcionario> getUsersByDepartamento(@RequestParam String nome) {
        try {
            // Filtra o funcionário com base no nome do departamento
            Funcionario funcionario = funcionarios.stream()
                    .filter(user -> user.getDepartamento().getNome().equals(nome)) // Comparando pelo nome do departamento
                    .findFirst()
                    .orElseThrow(() -> new FuncionarioNotFoundException("Usuário não encontrado"));
            return ResponseEntity.ok(funcionario);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.status(404).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }


    @GetMapping("/ordenados")
    public List<Funcionario> getAllFunMoney() {
        funcionarios.sort(Comparator.comparingDouble(Funcionario::getSalario).reversed());
        return funcionarios;
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
            funExistente.setSobrenome(funAtualizado.getSobrenome());
            funExistente.setSalario(funAtualizado.getSalario());
            funExistente.setCurso(funAtualizado.getCurso());
            funExistente.setDepartamento(funAtualizado.getDepartamento());

            return ResponseEntity.ok(funExistente);
        } catch (FuncionarioNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable("id") int id) {
        Funcionario funcionario = funcionarios.stream()
                .filter(func -> func.getId() == id)
                .findFirst()
                .orElse(null);

        if (funcionario == null) {
            return ResponseEntity.status(404).build();
        }

        funcionarios.remove(funcionario);
        return ResponseEntity.noContent().build();
    }
}

class FuncionarioNotFoundException extends RuntimeException {
    public FuncionarioNotFoundException(String message) {
        super(message);
    }

}
