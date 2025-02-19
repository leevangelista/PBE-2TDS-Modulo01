package com.example.Exerc9_MVC.banco;

import com.example.Exerc9_MVC.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeBD {

    public List<Employee> employees;

    public EmployeeBD() {
        this.employees = new ArrayList<>();
    }

    // Buscando todos empregados
    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

    // Busca apenas um empregado
    public Employee getByID(Long id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // Inserir empregado
    public boolean insert(Employee employee) {
        employees.add(employee);
        return true;
    }

    // Update empregado
    public boolean update(Long id, Employee employee) {
        Employee employeeBD = employees.stream()
                .filter(employeeFilter -> employeeFilter.getId() == id)
                .findFirst()
                .orElse(null);

        if (employeeBD == null) {
            return  false;
        }

        employeeBD.setNome(employee.getNome());
        employeeBD.setSobrenome(employee.getSobrenome());
        employeeBD.setCurso(employee.getCurso());
        employeeBD.setSalario(employee.getSalario());
        employeeBD.setDepartment(employee.getDepartment());

        return true;
    }

    // Delete empregado
    public boolean delete(Long id) {
        Employee employeeBD = employees.stream()
                .filter(employeeFilter -> employeeFilter.getId() == id)
                .findFirst()
                .orElse(null);

        if (employeeBD == null) {
            return false;
        }
        employees.remove(employeeBD);
        return true;
    }
}
