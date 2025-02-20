package com.example.ex9.view;


import com.example.ex9.controller.DepartamentoController;
import com.example.ex9.model.Departamento;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepView {

    DepartamentoController departamentoController = new DepartamentoController();
    @GetMapping
    public List<Departamento> getAll() {
        return departamentoController.getAll();
    }

    @GetMapping("/{id}")
    public Departamento getById(@PathVariable Long id) {
        return departamentoController.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Departamento departamento) {
        return departamentoController.insert(departamento);
    }

    @PutMapping("/{id}")
    public Departamento update(@RequestBody Departamento departamento, @PathVariable Long id) {
        return departamentoController.update(id, departamento);
    }

    @DeleteMapping("/{id}")
    public boolean delete ( @PathVariable Long id){
        return departamentoController.delete(id);
    }
}