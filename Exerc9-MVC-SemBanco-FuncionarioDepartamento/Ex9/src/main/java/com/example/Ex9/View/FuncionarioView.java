package com.example.Ex9.View;

import com.example.Ex9.Controller.FuncionarioController;
import com.example.Ex9.Model.Funcionario;
import jdk.jfr.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/funcionario")
public class FuncionarioView {
    FuncionarioController funcionarioController = new FuncionarioController();

    @GetMapping
    @Description("Retorna todos os funcionários")
    public List<Funcionario> getAll() {
        return funcionarioController.getAll();
    }

    @GetMapping("/{id}")
    public Funcionario getById(@PathVariable Long id) {
        return funcionarioController.getById(id);
    }

    @GetMapping("/curso")
    public Funcionario getByCurso(@RequestParam String curso) { return funcionarioController.getByCurso(curso); }

    @GetMapping("/departamento")
    public Funcionario getByDepartamento(@RequestParam String nome) { return funcionarioController.getByDepartamento(nome); }

    @GetMapping("/salarioOrdenado")
    public List<Funcionario> getFuncionariosOrdenadosPorSalario() { return funcionarioController.getFuncionarioOrdenadoPorSalario(); }

    @PostMapping
    public boolean insert(@RequestBody Funcionario funcionario) {
        return funcionarioController.insertBanco(funcionario);
    }

    @PutMapping("/{id}")
    public Funcionario update(@RequestBody Funcionario funcionario, @PathVariable Long id) {
        return funcionarioController.update(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return funcionarioController.delete(id);
    }
}
