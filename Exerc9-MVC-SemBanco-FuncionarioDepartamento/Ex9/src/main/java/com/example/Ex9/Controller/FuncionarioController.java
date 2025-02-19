package com.example.Ex9.Controller;

import com.example.Ex9.Banco.FuncionarioBd;
import com.example.Ex9.Model.Departamento;
import com.example.Ex9.Model.Funcionario;

import java.util.List;

public class FuncionarioController {

    FuncionarioBd repositorio = new FuncionarioBd();

    public List<Funcionario> getAll() {
        return repositorio.findAll();
    }

    public Funcionario getById(Long id) {
        return repositorio.getById(id);
    }

    public Funcionario getByCurso(String curso) { return repositorio.getByCurso(curso); }

    public Funcionario getByDepartamento(String nome) { return repositorio.getByDepartamento(nome); }

    public List<Funcionario> getFuncionarioOrdenadoPorSalario() { return repositorio.getFuncionariosOrdenadosPorSalario(); }

    public boolean insertBanco(Funcionario funcionario) {
        return repositorio.insert(funcionario);
    }

    public Funcionario update(Long id, Funcionario funcionario){
        boolean resultado = repositorio.update(id, funcionario);

        if(resultado) {
            return funcionario;
        }
        return null;
    }

    public boolean delete(Long id) {
        return repositorio.delete(id);
    }
}
