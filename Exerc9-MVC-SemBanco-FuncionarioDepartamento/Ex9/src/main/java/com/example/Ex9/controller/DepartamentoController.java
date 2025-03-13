package com.example.Ex9.controller;

import com.example.Ex9.banco.DepartamentoBd;
import com.example.Ex9.model.Departamento;

import java.util.List;

public class DepartamentoController {

    DepartamentoBd repository = new DepartamentoBd();

    public List<Departamento> getAll(){
        return repository.findAll();
    }

    public Departamento getById(int id){
        return repository.getById(id);
    }

    public boolean insertBanco(Departamento departamento){
        return repository.insert(departamento);
    }

    public Departamento update(int id, Departamento departamento){
        boolean result = repository.update(id, departamento);

        if(result){
            return departamento;
        }
        return null;
    }
}
