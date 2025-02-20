package com.example.ex9.banco;

import com.example.ex9.model.Departamento;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;


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
                .filter(dep -> dep.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //inserir dep
    public boolean insert (Departamento departamento){
        departamentos.add(departamento);
        return true;
    }
    //remover
    public boolean delete (Long id){
        Departamento d = departamentos.stream()
                .filter(dBd -> dBd.getId() == id)
                .findFirst()
                .orElse(null);

            if(d == null){
                return false;
            }
             departamentos.remove(d);
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
