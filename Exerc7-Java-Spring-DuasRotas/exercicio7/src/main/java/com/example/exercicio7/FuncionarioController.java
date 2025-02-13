package com.example.exercicio7;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioController {

    private List<Funcionario> funcionarios = new ArrayList<>();
    @GetMapping
    public List<Funcionario> getFuncionario(){
        return funcionarios;
    }
    @GetMapping("/{id}")
    @Operation(description = "Retorna o funcionario com base no id")
    public Funcionario getFuncionarioById(@PathVariable int id){
        return funcionarios.stream()
                        .filter(funcionario -> funcionario.getId() == id)
                                .findFirst()
                                        .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

    }

    @PostMapping
    @Operation(description = "Adicionar funcionario")
    public Funcionario creatFuncionario(@RequestBody Funcionario newFuncionario){
        funcionarios.add(newFuncionario);
        return newFuncionario;
    }

    @PutMapping("/{id}")
    @Operation(description = "Atualizar funcionario")
    public  String updateFuncionario(@PathVariable int id, @RequestBody Funcionario newFuncionario){
        Funcionario funcionario1 = funcionarios.stream()
                .filter(funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Funcionario não encontrado"));

        if (id >=0 ){
            funcionario1.setNome(newFuncionario.getNome());

            return "Nome atualizado";
        }
        else {
            return "Id inválido";
        }
    }
}
