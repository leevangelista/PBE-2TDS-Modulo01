package com.example.Ex9.Controller;

import com.example.Ex9.Banco.DepartamentoBd;
import com.example.Ex9.Model.Departamento;

import java.util.List;

public class DepartamentoController {

    DepartamentoBd repositorio = new DepartamentoBd();

    public List<Departamento> getAll() {
        return repositorio.findAll();
    }

    public Departamento getById(Long id) {
        return repositorio.getById(id);
    }

    public boolean insertBanco(Departamento departamento) {
        return repositorio.insert(departamento);
    }

    public Departamento update(Long id, Departamento departamento) {
        boolean resultado = repositorio.update(id, departamento);

        if(resultado) {
            return departamento;
        }
        return null;
    }

    public boolean delete(Long id) {
        boolean resultado = repositorio.delete(id);

        return resultado;
    }

}
