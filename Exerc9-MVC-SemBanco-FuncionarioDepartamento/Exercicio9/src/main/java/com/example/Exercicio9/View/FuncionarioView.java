package com.example.Exercicio9.View;

import com.example.Exercicio9.Controller.DepartamentoController;
import com.example.Exercicio9.Controller.FuncionarioController;
import com.example.Exercicio9.Model.Funcionario;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/funcionario")
public class FuncionarioView {
    FuncionarioController funcionarioController = new FuncionarioController();

    @GetMapping
    public List<Funcionario> getAll(@RequestParam(required = false) String curso, @RequestParam String nomeDepartamento){
        if(curso != null){
            return funcionarioController.getByCurso(curso);
        }else if (nomeDepartamento != null) {
            return funcionarioController.getByDepartamento(nomeDepartamento);
        }else{
            return funcionarioController.getAll();
        }
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathVariable Long id){
        return funcionarioController.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Funcionario funcionario){
        return funcionarioController.insertBanco(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario update(@RequestBody Funcionario funcionario, @PathVariable Long id){
        return funcionarioController.update(id, funcionario);
    }
}
