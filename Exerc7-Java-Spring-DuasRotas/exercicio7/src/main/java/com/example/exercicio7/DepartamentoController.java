package com.example.exercicio7;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/departamento")

public class DepartamentoController {

    private List<Departamento> departamentos = new ArrayList<>();

    @GetMapping
    public List<Departamento> getDepartamento(){
        return departamentos;
    }

    @GetMapping("/{id}")
    public  Departamento getDepartamentoById(@PathVariable int id){
        return departamentos.stream()
                .filter(departamento -> departamento.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

   @PostMapping
   public Departamento createDepartamnto(@RequestBody Departamento newDepartamento){
        departamentos.add(newDepartamento);
        return newDepartamento;
   }

   @PutMapping("/{id}")
    public Departamento atualizarDepartamento(@PathVariable int id, @RequestBody Departamento putDepartamento){
       Departamento depart = departamentos.stream()
               .filter(departamento -> departamento.getId() == id)
               .findFirst()
               .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    if (id >= 0){
        depart.setNome(putDepartamento.getNome());
        System.out.println("Alterado com sucesso!");
    }
    else {
        System.out.println("Id invalido!");
    }
    return depart;
   }
}
