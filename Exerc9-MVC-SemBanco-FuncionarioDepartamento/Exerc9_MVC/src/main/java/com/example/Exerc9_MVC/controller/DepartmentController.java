package com.example.Exerc9_MVC.controller;

import com.example.Exerc9_MVC.banco.DepartmentBD;
import com.example.Exerc9_MVC.model.Department;

import java.util.List;

public class DepartmentController {

    DepartmentBD repositoryDP = new DepartmentBD();

    // Buscar todos
    public List<Department> getAll() {
        return repositoryDP.findAll();
    }

    // Busca por id
    public Department getById(Long id) {
        return repositoryDP.getByID(id);
    }

    // Inserir departamento
    public boolean insert(Department department) {
        return  repositoryDP.insert(department);
    }

    // Update departamento
    public Department update(Long id, Department department) {
        boolean result = repositoryDP.update(id, department);

        if (result) { // Trata certo ou errado
            return department;
        }

        return null;
    }

    // Delete departamento
    public boolean delete(Long id) {
        boolean result = repositoryDP.delete(id);

        return result;
    }
}
