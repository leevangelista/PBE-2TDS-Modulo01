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
    public List<Employee> getAll() { // Buscando por todos empregados
        return employeeController.getAll();
    }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) { // Buscando por id
        return employeeController.getById(id);
    }

    @GetMapping("/curso")
    public Employee getByCurso(@RequestParam String curso) { // Busca por curso
        return employeeController.getByCurso(curso);
    }

    @GetMapping("/departamento")
    public Employee getByDepartamento(@RequestParam String nome) {
        return employeeController.getByDepartamento(nome);
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
