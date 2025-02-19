package com.example.Exerc9_MVC.view;

import com.example.Exerc9_MVC.controller.DepartmentController;
import com.example.Exerc9_MVC.model.Department;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentView {

    // Instanciando Controller
    DepartmentController departmentController = new DepartmentController();

    @GetMapping
    public List<Department> getAll() { // Buscando por todos departamento
        return departmentController.getAll();
    }

    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id) { // Buscando por id
        return departmentController.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody Department department) { // Criando empregado
        return departmentController.insert(department);
    }

    @PutMapping("/{id}")
    public Department update(@RequestBody Department department, @PathVariable Long id) { // Update departamento
        return departmentController.update(id, department);
    }
}
