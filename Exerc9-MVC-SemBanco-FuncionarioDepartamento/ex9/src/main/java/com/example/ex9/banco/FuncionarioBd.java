package com.example.ex9.banco;

import com.example.ex9.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioBd {

    private List<Funcionario> funcionarios;

    public FuncionarioBd(){
        this.funcionarios = new ArrayList<>();
    }
    //buscar duncionarios
    public List<Funcionario> findAll(){
        return new ArrayList<>(funcionarios);
    }
    //buscar unico funcionario
    public Funcionario getById(Long id){
        return funcionarios.stream()
                .filter(func -> func.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //inserir func
    public boolean insert (Funcionario funcionario){
        funcionarios.add(funcionario);
         return true;
    }

// atualizar func
    public boolean update (Long id, Funcionario funcionario){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

            if(funcionarioBd == null){
                return false;
            }
            funcionarioBd.setCurso(funcionario.getCurso());
            funcionarioBd.setDepartamento(funcionario.getDepartamento());
            funcionarioBd.setNome(funcionario.getNome());
            funcionarioBd.setSobrenome(funcionario.getSobrenome());
            funcionarioBd.setSalario(funcionario.getSalario());


            return true;
    }

}
