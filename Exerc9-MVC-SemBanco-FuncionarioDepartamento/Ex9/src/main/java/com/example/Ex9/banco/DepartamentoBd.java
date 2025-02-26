package com.example.Ex9.banco;

import com.example.Ex9.model.Departamento;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoBd {
    private List<Departamento> departamentos;

    public DepartamentoBd(){
        this.departamentos = new ArrayList<>();
    }

    // busca todos os funcionários
    public List<Departamento> findAll(){
        return new ArrayList<>(departamentos);
    }

    // busca um funcionário
    public Departamento getById(int id){
        return departamentos.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // insere o funcionário
    public boolean insert(Departamento departamento){
        departamentos.add(departamento);
        return true;
    }

    // atualiza o funcionário com base no id
    public boolean update(int id, Departamento departamento){
        Departamento departamentoBd = departamentos.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        if (departamentoBd == null){
            return false;
        }

        departamentoBd.setNome(departamento.getNome());

        return true;
    }
}
