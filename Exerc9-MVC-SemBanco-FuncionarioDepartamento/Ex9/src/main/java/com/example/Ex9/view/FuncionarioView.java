package com.example.Ex9.view;

import com.example.Ex9.controller.FuncionarioController;
import com.example.Ex9.model.Funcionario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioView {
    FuncionarioController funcionarioController = new FuncionarioController();

    @GetMapping
    public List<Funcionario> getFuncionarios(
            @RequestParam(required = false) String departamento,
            @RequestParam(required = false) String curso)
    {
        if (departamento != null) {
            return funcionarioController.getByDepartamento(departamento);
        }
        else if (curso != null) {
            return funcionarioController.getByCurso(curso);
        }
        else {
            return funcionarioController.getAll();
        }
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathVariable int id){
        return funcionarioController.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Funcionario funcionario){
        return funcionarioController.insertBanco(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario update(@RequestBody Funcionario funcionario, @PathVariable int id){
        return funcionarioController.update(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id){
        return funcionarioController.delete(id);
    }
}
