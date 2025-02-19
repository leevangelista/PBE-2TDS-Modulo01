package com.example.ex9.view;


import com.example.ex9.controller.DepartamentoController;
import com.example.ex9.controller.FuncionarioController;
import com.example.ex9.model.Departamento;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Departamento")
public class DepartamentoView {

    DepartamentoController departamentoController = new DepartamentoController();

    @GetMapping
    public List<Departamento> getAll(){
        return departamentoController.getAll();
    }

    @GetMapping("/{id}")
    public Departamento getById(@PathVariable Long id){
        return departamentoController.getById(id);
    }

    @PutMapping("/{id}")
    public Departamento update(@RequestBody Departamento departamento, @PathVariable Long id){
        return departamentoController.update(id, departamento);
    }

    @PostMapping
    public boolean insert (@RequestBody Departamento departamento){
        return departamentoController.insert(departamento);
    }

    @DeleteMapping("/{id}")
    public Departamento delete(@RequestBody Departamento departamento, @PathVariable Long id){
        return departamentoController.delete(id, departamento);
    }

}
