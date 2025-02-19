package com.example.Ex9.view;

import com.example.Ex9.Model.Departamento;
import com.example.Ex9.controller.DepartamentoController;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departamento")
public class DepartamentoView {
    DepartamentoController departamentocontroller = new DepartamentoController();

    @GetMapping
    public List<Departamento> getAll(){
        return departamentocontroller.getAll();
    }

    @GetMapping("/{id}")
    public Departamento getByid(@PathVariable Long id){
        return  departamentocontroller.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Departamento departamento){
        return departamentocontroller.insert(departamento);
    }

    @PutMapping("/{id}")
    public Departamento update (@RequestBody Departamento departamento, @PathVariable Long id){
        return departamentocontroller.update(id, departamento);

    }
    @DeleteMapping("/{id}")
    public void removerDepartamento(@PathVariable Long id) {
        departamentocontroller.removerDepartamento(id);
    }

}
