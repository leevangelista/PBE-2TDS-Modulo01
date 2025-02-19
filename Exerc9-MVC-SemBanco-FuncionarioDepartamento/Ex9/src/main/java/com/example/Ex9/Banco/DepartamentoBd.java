package com.example.Ex9.Banco;

import com.example.Ex9.Model.Departamento;
import com.example.Ex9.Model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class DepartamentoBd {
    private List<Departamento> departamentos;

    public DepartamentoBd() {
        this.departamentos = new ArrayList<>();
    }

    //busca todos departamentos
    public List<Departamento> findAll() {
        return new ArrayList<>(departamentos);
    }

    //busca um departamento
    public Departamento getById(Long id) {
        return departamentos.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //insere o departamento
    public boolean insert(Departamento departamento) {
        departamentos.add(departamento);
        return true;
    }

    //atualiza o departamento com base no id
    public boolean update(Long id, Departamento departamento) {
        Departamento departamentoBd = departamentos.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);

        if (departamentoBd == null) {
            return false;
        }

        departamentoBd.setNome(departamento.getNome());

        return true;
    }

    //deleta um departamento com base no id
    public boolean delete(Long id) {
        Departamento departamentoBd = departamentos.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);

        if (departamentoBd == null) {
            return false;
        }

        departamentos.remove(departamentoBd);
        return true;
    }
}
