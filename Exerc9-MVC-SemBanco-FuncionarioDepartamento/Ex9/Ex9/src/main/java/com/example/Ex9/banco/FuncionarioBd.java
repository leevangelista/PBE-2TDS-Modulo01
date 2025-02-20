package com.example.Ex9.banco;

import com.example.Ex9.Model.Funcionario;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FuncionarioBd {
    private List<Funcionario> funcionarios;

    public FuncionarioBd() {
        this.funcionarios = new ArrayList<>();
    }

    //buscar todos os usuarios
    public List<Funcionario> findAll(){
        return new ArrayList<>(funcionarios);
    }
    //buscar apenas um usuario

    public Funcionario getById(long id){
        return funcionarios.stream()
                .filter( fun -> fun.getId() == id)
                .findFirst()
                .orElse(null);
    }
    public Funcionario getByCurso(String curso){
        return (Funcionario) funcionarios.stream()
                .filter(f -> f.getCurso().equalsIgnoreCase(curso))
                .collect(Collectors.toList());
    }
    // insert user
    public boolean insert(Funcionario funcionario){
        funcionarios.add(funcionario);
        return true;
    }

    //update user
    public boolean update(long id, Funcionario funcionario) {
        Funcionario funcionarioBD = funcionarios.stream()
                .filter(objeto -> objeto.getId() == id)
                .findFirst()
                .orElse(null);


        if (funcionarioBD == null){
            return false;
        }
        funcionarioBD.setNome(funcionario.getNome());
        funcionarioBD.setSobrenome(funcionario.getSobrenome());
        funcionarioBD.setCurso(funcionario.getCurso());
        funcionarioBD.setDepartamento(funcionario.getDepartamento());
        funcionarioBD.setSalario(funcionario.getSalario());
        return true;
    }
    public boolean removerFuncionario(@PathVariable Long id) {
        return funcionarios.removeIf(f -> f.getId() == (id));
    }
}
