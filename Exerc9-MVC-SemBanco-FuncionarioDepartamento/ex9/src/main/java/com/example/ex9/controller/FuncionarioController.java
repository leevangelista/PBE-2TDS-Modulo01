package com.example.ex9.controller;

import com.example.ex9.banco.FuncionarioBd;
import com.example.ex9.model.Departamento;
import com.example.ex9.model.Funcionario;

import java.util.List;

public class FuncionarioController {

    FuncionarioBd repository = new FuncionarioBd();

    //buscar todos
    public List<Funcionario> getAll(){
        return repository.findAll();
    }

    public Funcionario getById(Long id){
        return repository.getById(id);
    }

    public boolean insert(Funcionario funcionario){
        return repository.insert(funcionario);
    }

    public Funcionario update(Long id, Funcionario funcionario){
        boolean result = repository.update(id, funcionario);

        if(result) {
            return funcionario;
        }
        return null;
    }

    public Funcionario delete(Long id, Funcionario funcionario){
        boolean result = repository.delete(id, funcionario);

        if(result) {
            return funcionario;
        }
        return null;
    }
}
