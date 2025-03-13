package com.example.Ex9.view;

import com.example.Ex9.controller.DepartamentoController;
import com.example.Ex9.model.Departamento;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoView {
    DepartamentoController departamentoController = new DepartamentoController();

    @GetMapping
    public List<Departamento> getAll() {
        return departamentoController.getAll();
    }

    @GetMapping("/{id}")
    public Departamento getById(@PathVariable int id) {
        return departamentoController.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Departamento departamento) {
        return departamentoController.insertBanco(departamento);
    }

    @PutMapping("/{id}")
    public Departamento update(@RequestBody Departamento departamento, @PathVariable int id) {
        return departamentoController.update(id, departamento);
    }
}
