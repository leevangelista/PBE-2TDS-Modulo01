package com.example.Ex9.view;

import com.example.Ex9.Model.Funcionario;

import com.example.Ex9.controller.FuncionarioController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/funcionario")
public class FuncionarioView {
    FuncionarioController funcionariocontroll = new FuncionarioController();

    @GetMapping
    public List<Funcionario> getAll(){
        return funcionariocontroll.getAll();
    }

    @GetMapping("/funcionario/{id}")
    public Funcionario getByid(@PathVariable Long id){
        return  funcionariocontroll.getById(id);
    }
    @RequestParam()
    public Funcionario getByCurso(@PathVariable String curso){
        return funcionariocontroll.getByCurso(curso);
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
