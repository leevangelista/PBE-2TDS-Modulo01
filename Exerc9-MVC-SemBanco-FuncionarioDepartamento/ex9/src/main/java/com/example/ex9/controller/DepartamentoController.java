package com.example.ex9.controller;

import com.example.ex9.banco.DepartamentoBd;
import com.example.ex9.model.Departamento;

import java.util.List;

public class DepartamentoController {

    DepartamentoBd depRepository = new DepartamentoBd();

    public List<Departamento> getAll(){
        return depRepository.findAll();
    }

    public Departamento getById(Long id){
        return depRepository.getById(id);
    }

    public boolean insert(Departamento departamento){
        return depRepository.insert(departamento);
    }

    public Departamento update (Long id , Departamento departamento){
        boolean result = depRepository.update(id, departamento);

        if (result ){
            return departamento;
        }

        return null;
    }

    public boolean delete (Long id ) {
        return depRepository.delete(id);

    }


}
