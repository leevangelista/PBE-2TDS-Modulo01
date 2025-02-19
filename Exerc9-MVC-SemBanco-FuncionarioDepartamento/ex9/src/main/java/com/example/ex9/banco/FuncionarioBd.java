package com.example.ex9.banco;

import com.example.ex9.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioBd {

    private List<Funcionario> funcionarios;

    public FuncionarioBd(){
        this.funcionarios = new ArrayList<>();
    }

    //busca todos funcionarios
    public List<Funcionario> findAll(){
        return new ArrayList<>(funcionarios);
    }

    //busca apenas um funcionario
    public Funcionario getById(Long id){
        return funcionarios.stream()
                .filter( funcionario -> funcionario.getId() == id)
                .findFirst()
                .orElse(null);
    }

    //insert funcionario
    public boolean insert(Funcionario funcionario){
        funcionarios.add(funcionario);
        return true;
    }

    //update funcionario
    public boolean update(Long id, Funcionario funcionario){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(f -> f.getId() == id )
                .findFirst()
                .orElse(null);

        if (funcionarioBd == null){
            return false;
        }
        funcionarioBd.setNome(funcionario.getNome());
        funcionarioBd.setSobrenome(funcionario.getSobrenome());
        funcionarioBd.setCurso(funcionario.getCurso());
        funcionarioBd.setDepartamento(funcionario.getDepartamento());
        funcionarioBd.setSalario(funcionario.getSalario());

        return true;
    }
}
