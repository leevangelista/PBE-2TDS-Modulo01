package com.example.Exerc9_MVC.banco;

import com.example.Exerc9_MVC.model.Department;

import java.util.ArrayList;
import java.util.List;

public class DepartmentBD {

    public List<Department> departments;

    public DepartmentBD() {
        this.departments = new ArrayList<>();
    }

    // Buscando todos departamentos
    public List<Department> findAll() {
        return new ArrayList<>(departments);
    }

    // Busca apenas um departamento
    public Department getByID(Long id) {
        return departments.stream()
                .filter(department -> department.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Inserir departamento
    public boolean insert(Department department) {
        departments.add(department);
        return true;
    }

    // Update departamento
    public boolean update(Long id, Department department) {
        Department departmentBD = departments.stream()
                .filter(departmentFilter -> departmentFilter.getId() == id)
                .findFirst()
                .orElse(null);

        if (departmentBD == null) {
            return  false;
        }

        departmentBD.setNome(department.getNome());

        return true;
    }
}
