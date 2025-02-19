package com.example.atv9.banco;

import com.example.atv9.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioBd {
    private List<Funcionario> funcionarios;

    public FuncionarioBd(){
        this.funcionarios = new ArrayList<>();
    }

    // busca todos os usuário
    public List<Funcionario> findAll(){
        return new ArrayList<>(funcionarios);
    }

    // busca um user
    public Funcionario getById(int id){
        return funcionarios.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // insere o user
    public boolean insert(Funcionario user){
        funcionarios.add(user);
        return true;
    }

    // atualiza o funcionário com base no id
    public boolean update(int id, Funcionario user){
        Funcionario userBd = funcionarios.stream()
                .filter(f -> f.getId() == id)
                .findFirst()
                .orElse(null);

        if (userBd == null){
            return false;
        }

        userBd.setNome(user.getNome());

        return true;
    }
}