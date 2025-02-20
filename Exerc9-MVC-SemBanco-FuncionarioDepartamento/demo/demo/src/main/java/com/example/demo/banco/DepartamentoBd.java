package com.example.demo.banco;

import com.example.demo.model.Departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoBd {
    private List<Departamento> departamentos;

    public DepartamentoBd(){
        this.departamentos = new ArrayList<>();
    }
    // buscar todos
    public List<Departamento> findAll(){
        return new ArrayList<>(departamentos);
    }
    public Departamento getById(long id){
        return departamentos.stream()
                .filter( departamento -> departamento.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // insert departamento
    public boolean insert(Departamento departamento){
        departamentos.add(departamento);
        return true;
    }
    public boolean update(Long id, Departamento departamento){
        Departamento departamentoBd = departamentos.stream()
                .filter( departamento1 -> departamento1.getId() == id)
                .findFirst()
                .orElse(null);

        if (departamentoBd == null){
            return false;
        }
        departamentoBd.setNome(departamento.getNome());
        return true;
    }
    public boolean delete(Long id){
        Departamento departamentoBd = departamentos.stream()
                .filter( departamento1 -> departamento1.getId() == id)
                .findFirst()
                .orElse(null);
        if (departamentoBd == null){
            return false;
        }
        departamentos.remove(departamentoBd);

        return true;

    }
}
