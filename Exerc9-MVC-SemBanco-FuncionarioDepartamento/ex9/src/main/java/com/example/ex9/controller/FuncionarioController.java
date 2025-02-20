package com.example.ex9.controller;

import com.example.ex9.banco.FuncionarioBd;

import com.example.ex9.model.Departamento;
import com.example.ex9.model.Funcionario;

import java.util.List;

public class FuncionarioController {

    FuncionarioBd funcRepository = new FuncionarioBd();

    public List<Funcionario> getAll() {
        return funcRepository.findAll();
    }

    public List<Funcionario> getByCurso(String curso){
        return funcRepository.findByCurso(curso);
    }

    public List<Funcionario> funcionariosOrdenados(double salario){
        return funcRepository.funcionariosOrdenados();
    }

    public List<Funcionario> getByDepartamento(String nomeDepartamento){
        return funcRepository.findByDepartamento(nomeDepartamento);
    }
    public Funcionario getById(Long id) {
        return funcRepository.getById(id);
    }

    public boolean insert(Funcionario funcionario) {
        return funcRepository.insert(funcionario);
    }

    public Funcionario update(Long id, Funcionario funcionario) {
        boolean result = funcRepository.update(id, funcionario);

        if (result) {
            return funcionario;
        }

        return null;
    }

    public boolean delete(Long id) {
        return funcRepository.delete(id);
    }
}



