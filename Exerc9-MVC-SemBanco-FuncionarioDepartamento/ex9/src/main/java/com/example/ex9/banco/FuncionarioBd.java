package com.example.ex9.banco;

import com.example.ex9.model.Departamento;
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

    public boolean delete(Long id, Funcionario funcionario){
        Funcionario funcionarioBd = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);
        if (funcionarioBd == null) {
            return false;
        }
        funcionarios.remove(funcionarioBd);
        return true;
    }

    //buscar todos pelo curso
    public <List>FuncionarioBd getByCurso(String curso){
        return funcionarios.stream()
                .filter( fun -> fun.getCurso().equals(curso);
    }

    public Funcionario getByDepartamento(Departamento departamento){
        return funcionarios.stream()
                .filter( fun -> fun.getDepartamento().equals(departamento))
                .findFirst()
                .orElse(null);
    }
}
