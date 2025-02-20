package com.example.Exerc9_MVC.view;

import com.example.Exerc9_MVC.controller.EmployeeController;
import com.example.Exerc9_MVC.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeView {

    // Instanciando Conroller
    EmployeeController employeeController = new EmployeeController();

    @GetMapping
    public List<Employee> getAll(
            @RequestParam(required = false) String curso, // Filtro de curso
            @RequestParam(required = false) String nomeDepartamento // Filtro de departamento
    ) {
        // Verificações para busca
        if (curso != null) {
            return employeeController.getByCurso(curso); // Filtro de curso
        } else if (nomeDepartamento != null) {
            return employeeController.getByDepartamento(nomeDepartamento); // Filtro de departamento
        } else {
            return employeeController.getAll(); // Buscando por todos empregados
        }
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) { // Buscando por id
        return employeeController.getById(id);
    }

    @GetMapping("/salarioOrdenado")
    public List<Employee> getBySalarioOrdenado() {
        return employeeController.getBySalarioOrdenado();
    }

    @PostMapping
    public boolean insert(@RequestBody Employee employee) { // Criando empregado
        return employeeController.insert(employee);
    }

    @PutMapping("/{id}")
    public Employee update(@RequestBody Employee employee, @PathVariable Long id) { // Update empregado
        return employeeController.update(id, employee);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable Long id) { // Delete empregado
        return employeeController.delete(id);
    }
}
