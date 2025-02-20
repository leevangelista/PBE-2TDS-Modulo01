package com.example.exercicio9.controller;


import com.example.exercicio9.banco.FuncionarioBd;
import com.example.exercicio9.model.Funcionario;

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

    public  Funcionario getById(Long id){

        return repository.getByID(id);
    }

    public boolean insertBanco(Funcionario funcionario){
        return  repository.insert(funcionario);
    }

    public  Funcionario update(Long id, Funcionario funcionario){
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
