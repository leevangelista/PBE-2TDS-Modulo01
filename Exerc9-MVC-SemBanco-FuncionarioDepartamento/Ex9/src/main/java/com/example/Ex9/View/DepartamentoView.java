package com.example.Ex9.View;

import com.example.Ex9.Controller.DepartamentoController;
import com.example.Ex9.Model.Departamento;
import jdk.jfr.Description;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoView {
    DepartamentoController departamentoController = new DepartamentoController();

    @GetMapping
    @Description("Retorna todos os departamentos")
    public List<Departamento> getAll() {
        return departamentoController.getAll();
    }

    @GetMapping("/{id}")
    public Departamento getById(@PathVariable Long id) {
        return departamentoController.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Departamento departamento) {
        return departamentoController.insertBanco(departamento);
    }

    @PutMapping("/{id}")
    public Departamento update(@RequestBody Departamento departamento, @PathVariable Long id) {
        return departamentoController.update(id, departamento);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) {
        return departamentoController.delete(id);
    }
}
