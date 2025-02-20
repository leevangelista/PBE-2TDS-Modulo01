package com.example.Exercicio9.Controller;

import com.example.Exercicio9.Banco.DepartamentoBD;
import com.example.Exercicio9.Banco.FuncionarioBD;
import com.example.Exercicio9.Model.Funcionario;

import java.util.List;

public class FuncionarioController {
    FuncionarioBD repository = new FuncionarioBD();

    public List<Funcionario> getAll(){
        return repository.findAll();
    }

    public List<Funcionario> getByDepartamento(String nomeDepartamento){
        return repository.findByDepartamento(nomeDepartamento);
    }

    public List<Funcionario> getByCurso(String curso) {
        return repository.findByCurso(curso);
    }

    public Funcionario getById(Long id){
        return repository.getById(id);
    }

    public boolean insertBanco(Funcionario funcionario){
        return repository.insert(funcionario);
    }

    public Funcionario update(Long id, Funcionario funcionario){
        boolean result = repository.update(id, funcionario);

        if(result){
            return funcionario;
        }
        return null;
    }
}
