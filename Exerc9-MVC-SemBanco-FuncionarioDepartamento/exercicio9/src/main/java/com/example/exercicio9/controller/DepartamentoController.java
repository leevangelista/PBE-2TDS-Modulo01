package com.example.exercicio9.controller;

import com.example.exercicio9.banco.DepartamentoBd;
import com.example.exercicio9.model.Departamento;

import java.util.List;

public class DepartamentoController {

    DepartamentoBd repository = new DepartamentoBd();

    public List<Departamento> getAll(){
        return repository.findAll();
    }

    public  Departamento getById(Long id){

        return repository.getById(id);
    }

    public boolean insertBanco(Departamento departamento){
        return  repository.insert(departamento);
    }

    public  Departamento update(Long id, Departamento departamento){
        boolean result = repository.update(id, departamento);

        if (result){
            return departamento;
        }
        return null;
    }
}
