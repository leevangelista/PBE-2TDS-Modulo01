package com.example.ex9.banco;

import com.example.ex9.model.Departamento;


import java.util.ArrayList;
import java.util.List;

public class DepartamentoBd {

    private List<Departamento> departamentos;

    public DepartamentoBd(){
        this.departamentos = new ArrayList<>();
    }
    //buscar departamentos
    public List<Departamento> findAll(){
        return new ArrayList<>(departamentos);
    }
    //buscar unico dep
    public Departamento getById(Long id){
        return departamentos.stream()
                .filter(func -> func.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //inserir dep
    public boolean insert (Departamento departamento){
        departamentos.add(departamento);
        return true;
    }

    // atualizar dep
    public boolean update (Long id, Departamento departamento){
        Departamento departamentoBd = departamentos.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);

        if(departamentoBd == null){
            return false;
        }
        departamentoBd.setNome(departamento.getNome());
        return true;
    }
}
