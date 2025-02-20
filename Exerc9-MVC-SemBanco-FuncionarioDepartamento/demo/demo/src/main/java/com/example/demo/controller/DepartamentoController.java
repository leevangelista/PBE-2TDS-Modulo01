package com.example.demo.controller;

import com.example.demo.banco.DepartamentoBd;
import com.example.demo.model.Departamento;

import java.util.List;

public class DepartamentoController {
    DepartamentoBd repository = new DepartamentoBd();

    public List<Departamento> getAll(){
        return repository.findAll();
    }

    public Departamento getById(Long id){
        return repository.getById(id);
    }
    public boolean insert(Departamento departamento){
        return repository.insert(departamento);
    }
    public Departamento update(Long id, Departamento departamento){
        boolean result = repository.update(id, departamento);

        if (result){
            return departamento;
        }
        return null;
    }
    public boolean delete(Long id){
        return repository.delete(id);
    }
}
