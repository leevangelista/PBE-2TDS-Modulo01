package com.example.Exercicio9.Banco;

import com.example.Exercicio9.Model.Funcionario;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FuncionarioBD {
    private List<Funcionario> func;

    public FuncionarioBD(){
        this.func = new ArrayList<>();
    }

    // busca todos os usuário
    public List<Funcionario> findAll(){
        return new ArrayList<>(func);
    }
    public List<Funcionario> findByCurso(String curso){
        return func.stream()
                .filter(funcionario -> funcionario.getCurso().equals(curso))
                .toList();
    }

    public List<Funcionario> findByDepartamento(String nome){
        return func.stream()
                .filter(funcionario -> funcionario.getDepartamento().getNome().equals(nome))
                .toList();
    }

    // busca um user
    public Funcionario getById(Long id){
        return func.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // insere o user
    public boolean insert(Funcionario user){
        func.add(user);
        return true;
    }

    // atualiza o funcionário com base no id
    public boolean update(Long id, Funcionario departamento){
        Funcionario funcionarioBD = func.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        if (funcionarioBD == null){
            return false;
        }

        funcionarioBD.setNome(departamento.getNome());

        return true;
    }
    public List<Funcionario> funcOrdenados(){
        return func.stream().sorted(Comparator.comparing(Funcionario::getSalario).reversed()).toList();
    }
}
