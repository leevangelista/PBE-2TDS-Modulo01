package com.example.Ex9.controller;

import com.example.Ex9.banco.FuncionarioBd;
import com.example.Ex9.model.Funcionario;

import java.util.List;

public class FuncionarioController {

    FuncionarioBd repository = new FuncionarioBd();

    public List<Funcionario> getAll(){
        return repository.findAll();
    }

    public List<Funcionario> getByCurso(String curso){
        return repository.findByCurso(curso);
    }

    public List<Funcionario> getByDepartamento(String deparatamento){
        return repository.findByDepartamento(deparatamento);
    }

    public Funcionario getById(int id){
        return repository.getById(id);
    }


    public boolean insertBanco(Funcionario funcionario){
        return repository.insert(funcionario);
    }

    public Funcionario update(int id, Funcionario funcionario){
        boolean result = repository.update(id, funcionario);

        if(result){
            return funcionario;
        }
        return null;
    }

    public boolean delete(int id){
        return repository.delete(id);
    }
}
