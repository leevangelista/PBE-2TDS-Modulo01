package com.example.Exercicio9.Controller;

import com.example.Exercicio9.Banco.DepartamentoBD;
import com.example.Exercicio9.Model.Departamento;

import java.util.List;

public class DepartamentoController {
    DepartamentoBD repository = new DepartamentoBD();

    public List<Departamento> getAll(){
        return repository.findAll();
    }

    public Departamento getById(Long id){
        return repository.getById(id);
    }

    public boolean insertBanco(Departamento departamento){
        return repository.insert(departamento);
    }

    public Departamento update(Long id, Departamento departamento){
        boolean result = repository.update(id, departamento);

        if(result){
            return departamento;
        }
        return null;
    }

    public boolean delete(Long id) {
        return repository.delete(id);
    }
}
