package com.example.exercicio9.view;

import com.example.exercicio9.controller.DepartamentoController;
import com.example.exercicio9.controller.FuncionarioController;

import com.example.exercicio9.model.Funcionario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioView {
    FuncionarioController funcionarioController = new FuncionarioController();
    @GetMapping
    public List<Funcionario> getAll(
            @RequestParam(required = false) String curso,
            @RequestParam(required = false) String nomeDepartamento,
            @RequestParam(required = false) double salario
    ){
        if (curso != null){
            return  funcionarioController.getByCurso(curso);
        } else if (nomeDepartamento != null) {
            return  funcionarioController.getByDepartamento(nomeDepartamento);
        } else if (salario >= 0 ) {
            return funcionarioController.getBySalario(salario);
        } else {
            return funcionarioController.getAll();
        }
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathVariable Long id){
        return  funcionarioController.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Funcionario funcionario){
        return  funcionarioController.insertBanco(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario update(@RequestBody Funcionario funcionario, @PathVariable Long id){
        return funcionarioController.update(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id){
        return funcionarioController.delete(id);
    }

}
