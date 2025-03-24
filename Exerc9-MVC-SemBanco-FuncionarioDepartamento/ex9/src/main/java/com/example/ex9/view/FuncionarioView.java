package com.example.ex9.view;


import com.example.ex9.controller.FuncionarioController;
import com.example.ex9.model.Departamento;
import com.example.ex9.model.Funcionario;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioView {

    FuncionarioController funcionarioController = new FuncionarioController();

    @GetMapping
    public List<Funcionario> getAll(@RequestParam(required = false) String curso, @RequestParam(required = false) Departamento departamento, @RequestParam(required = false) Double salario){

        if(curso != null){
            return funcionarioController.getByCurso(curso);
        }
        else if(departamento != null){
            return funcionarioController.getByDepartamento(departamento);
        }
        else if (salario != null) {
            return funcionarioController.funcionariosOrdenados();
        }
        else {
            return funcionarioController.getAll();
        }
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathVariable Long id){
        return funcionarioController.getById(id);
    }

    @PutMapping("/{id}")
    public Funcionario update(@RequestBody Funcionario funcionario, @PathVariable Long id){
        return funcionarioController.update(id, funcionario);
    }

    @PostMapping
    public boolean insert (@RequestBody Funcionario funcionario){
        return funcionarioController.insert(funcionario);
    }

    @DeleteMapping("/{id}")
    public Funcionario delete(@RequestBody Funcionario funcionario, @PathVariable Long id){
        return funcionarioController.delete(id, funcionario);
    }

    /*@GetMapping("/curso")
    public Funcionario getByCurso(@RequestParam String curso){
        return (Funcionario) funcionarioController.getByCurso(curso);
    }
    @GetMapping("/departamento ")
  public Funcionario getByDepartamento(@RequestParam Departamento departamento){
     return funcionarioController.getByDepartamento(departamento);
   }*/

}
