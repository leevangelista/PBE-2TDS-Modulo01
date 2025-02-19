package com.example.ex9.banco;

import com.example.ex9.model.Departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoBd {

    private List<Departamento> departamentos;

    public DepartamentoBd(){
        this.departamentos= new ArrayList<>();
    }

    //busca todos departamentos
    public List<Departamento> findAll(){
        return new ArrayList<>(departamentos);
    }

    //busca apenas um departamentos
    public Departamento getById(Long id){
        return departamentos.stream()
                .filter( departamento -> departamento.getId()== id)
                .findFirst()
                .orElse(null);
    }

    //insert departamentos
    public boolean insert(Departamento departamento){
        departamentos.add(departamento);
        return true;
    }

    //update departamento
    public boolean update(Long id, Departamento departamento){
        Departamento departamentoBd = departamentos.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);

        if (departamentoBd == null){
            return false;
        }
        departamentoBd.setNome(departamento.getNome());
        return true;
    }
}
