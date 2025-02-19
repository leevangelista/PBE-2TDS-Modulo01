package com.example.Exerc9_MVC.controller;

import com.example.Exerc9_MVC.banco.EmployeeBD;
import com.example.Exerc9_MVC.model.Employee;

import java.util.List;

public class EmployeeController {

    EmployeeBD repositoryEP = new EmployeeBD();

    // Buscar todos
    public List<Employee> getAll() {
        return repositoryEP.findAll();
    }

    // Buscar por id
    public Employee getById(Long id) {
        return repositoryEP.getByID(id);
    }

    // Inserir empregado
    public boolean insert(Employee employee) {
        return repositoryEP.insert(employee);
    }

    // Update empregado
    public Employee update(Long id,Employee employee) {
        boolean result = repositoryEP.update(id, employee);

        if (result) { // Trata certo ou errado
            return employee;
        }

        return null;
    }
}
