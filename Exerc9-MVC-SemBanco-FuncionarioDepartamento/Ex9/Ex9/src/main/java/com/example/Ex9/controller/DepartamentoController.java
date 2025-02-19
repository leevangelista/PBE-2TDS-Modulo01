package com.example.Ex9.controller;

import com.example.Ex9.Model.Departamento;
import com.example.Ex9.banco.DepartamentoBd;

import java.util.List;


public class DepartamentoController {

        //buscar todos
        DepartamentoBd repository = new DepartamentoBd();
        public List<Departamento> getAll() {
            return repository.findAll();
        }
        public Departamento getById(Long id){
            return repository.getById(id);
        }
        public boolean insert (Departamento departamento){
            return repository.insert(departamento);
        }
        public Departamento update(Long id, Departamento departamento){
            boolean result = repository.update(id, departamento);
            if(result){
                return  departamento;
            }
            return null;
        }
    public boolean removerDepartamento(Long id) {
        return repository.removerDepartamento(id);
    }

    }