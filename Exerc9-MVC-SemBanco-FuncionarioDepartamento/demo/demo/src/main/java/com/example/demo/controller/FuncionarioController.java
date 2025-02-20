package com.example.demo.controller;

import com.example.demo.banco.DepartamentoBd;
import com.example.demo.banco.FuncionarioBd;
import com.example.demo.model.Departamento;
import com.example.demo.model.Funcionario;

import java.util.List;

public class FuncionarioController {
    FuncionarioBd repository = new FuncionarioBd();

    public List<Funcionario> getAll(){
        return repository.findAll();
    }
    public List<Funcionario> getByCurso(String curso){
     return repository.findByCurso(curso);
    }
    public List<Funcionario> getByDepartamento(String nomeDepartamento){
        return repository.findByDepartamento(nomeDepartamento);
    }


    public Funcionario getById(Long id){
        return repository.getById(id);
    }
    public boolean insert(Funcionario funcionario){
        return repository.insert(funcionario);
    }
    public Funcionario update(Long id, Funcionario funcionario){
        boolean result = repository.update(id, funcionario);

        if (result){
            return funcionario;
        }
        return null;
    }
    public boolean delete(Long id){
        return repository.delete(id);
    }
}
