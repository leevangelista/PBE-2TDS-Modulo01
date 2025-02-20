package com.example.ex9.view;

import com.example.ex9.controller.FuncionarioController;
import com.example.ex9.model.Funcionario;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/funcionario")
@RestController
public class FuncView {

    FuncionarioController funcionarioController = new FuncionarioController();

    @GetMapping
    public List<Funcionario> getAll(
            @RequestParam (required = false) String curso,
            @RequestParam (required = false) String nomeDepartamento,
            @RequestParam (required = false) Double funcionariosOrdenados
    ) {
        if (curso != null) {
            return funcionarioController.getByCurso(curso);
        } else if (nomeDepartamento != null) {
            return funcionarioController.getByDepartamento(nomeDepartamento);
        }else if(funcionariosOrdenados != null){
            return funcionarioController.funcionariosOrdenados(funcionariosOrdenados);
        }else{

            return funcionarioController.getAll();
        }
    }


    @GetMapping("/{id}")
    public Funcionario getById (@PathVariable Long id){
        return funcionarioController.getById(id);

    }

    @PostMapping
    public boolean insert (@RequestBody Funcionario funcionario){
        return funcionarioController.insert(funcionario);

    }

    @PutMapping("/{id}")
    public Funcionario update(@RequestBody Funcionario funcionario, @PathVariable Long id){
        return funcionarioController.update(id, funcionario);
    }

    @DeleteMapping("/{id}")
    public boolean delete (@PathVariable Long id){
        return funcionarioController.delete(id);
    }
}
