package com.example.exercicio7;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoController {

    private List<Departamento> departamentos  = new ArrayList<>();
    @GetMapping
    public List<Departamento> getDepartamentos(){
        return  departamentos;
    }

    @GetMapping("/{id}")
    @Operation(description = "Retorna o usuário com base no id")
    public Departamento getDepartamentosById(@PathVariable int id){
        return departamentos
                .stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("erro"));
    }

    @PostMapping
    public Departamento creatDepartamento(@RequestBody Departamento newDepartamento){
        departamentos.add(newDepartamento);
        return newDepartamento;
    }

    @PutMapping("/{id}")
    public String updateDepartamento(@PathVariable int id, @RequestBody Departamento newDepartamento){
        Departamento departamento = departamentos.stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Departamento não encontrado"));

        if (id >= 0){
            departamento.setNome(newDepartamento.getNome());
            return "Nome atualizado";
        }
        else {
            return "id inválido";
        }
    }

}
