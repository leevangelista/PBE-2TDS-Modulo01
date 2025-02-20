package com.example.Ex9.controller;


import com.example.Ex9.Model.Funcionario;
import com.example.Ex9.banco.FuncionarioBd;

import java.util.List;


public class FuncionarioController {

    //buscar todos
    FuncionarioBd repository = new FuncionarioBd();
    public List<Funcionario> getAll() {
        return repository.findAll();
    }
    public Funcionario getById(Long id){
        return repository.getById(id);
    }
    public Funcionario getByCurso(String curso){
        return repository.getByCurso(curso);
    }

    public boolean insert (Funcionario funcionario){
        return repository.insert(funcionario);
    }
    public Funcionario update(Long id, Funcionario funcionario){
        boolean result = repository.update(id, funcionario);
        if(result){
            return  funcionario;
        }
        return null;
    }
    public boolean removerFuncionario(Long id) {
        return repository.removerFuncionario(id);
    }
}