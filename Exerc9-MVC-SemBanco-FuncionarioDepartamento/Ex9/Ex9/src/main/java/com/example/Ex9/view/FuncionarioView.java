package com.example.Ex9.view;

import com.example.Ex9.Model.Funcionario;

import com.example.Ex9.controller.FuncionarioController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioView {
    FuncionarioController funcionariocontroll = new FuncionarioController();
//    @GetMapping
//    public List<Funcionario> getAll(){
//        return funcionariocontroll.getAll();
//    }
    @GetMapping
    public List<Funcionario> getAll(@RequestParam(required = false) String curso,
                                    @RequestParam(required = false) String nomeDepartamento,
                                    @RequestParam (required = false) Double salario ){
        if(curso != null){
            return funcionariocontroll.getByCurso(curso);
        } else if(nomeDepartamento != null){
            return funcionariocontroll.getByDepartamento(nomeDepartamento);
        }else if(salario != null){
            return funcionariocontroll.getBySalarios(salario);
        } else {
            return funcionariocontroll.getAll();
        }
    }
    @GetMapping("/funcionario/{id}")
    public Funcionario getByid(@PathVariable Long id){
        return  funcionariocontroll.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Funcionario funcionario){
        return funcionariocontroll.insert(funcionario);
    }
    @PutMapping("/Funcionario/{id}")
    public Funcionario update (@RequestBody Funcionario funcionario, @PathVariable Long id){
        return funcionariocontroll.update(id, funcionario);
    }
    @DeleteMapping("/{id}")
    public void removerFuncionario(@PathVariable Long id) {
       funcionariocontroll.removerFuncionario(id);
    }
}
