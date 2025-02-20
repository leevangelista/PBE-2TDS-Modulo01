package com.example.exercicio9.banco;

import com.example.exercicio9.model.Departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoBd {
    private List<Departamento> departamentos;
    public DepartamentoBd(){
        this.departamentos = new ArrayList<>();
    }

    //buscar todos os departamentos

    public List<Departamento> findAll() {
        return new ArrayList<>(departamentos);
    }

    //buscar um departamento pelo id

    public Departamento getById(Long id){
        return  departamentos.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //inserir departamento

    public boolean insert(Departamento departamento){
        departamentos.add(departamento);
        return true;
    }

    //atualizar o departamento pelo id

    public  boolean update(Long id, Departamento departamento){
        Departamento departamentoBd = departamentos.stream()
                .filter(dep -> dep.getId() == id)
                .findFirst()
                .orElse(null);

        if(departamentoBd == null){
            return false;
        }

        departamentoBd.setNome(departamento.getNome());

        return true;
    }

}
