package com.example.ATV_09.banco;

import com.example.ATV_09.model.Funcionario;

import java.util.ArrayList;
import java.util.List;

public class FuncionarioBd {
    private List<Funcionario> funcionarios;

    public FuncionarioBd(){
        this.funcionarios = new ArrayList<>();
    }
    //buscar todos usuários
    public List<Funcionario> findAll(){
        return new ArrayList<>(funcionarios);
    }

    //busca apenas um usuário
    public Funcionario getById(Long id){
        return funcionarios.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElse(null);
    }
    //insert user
    public boolean insert(Funcionario user){
        funcionarios.add(user);
        return true;
    }
    //uptade user
    public boolean update(Long id, Funcionario user){
        Funcionario userBd = funcionarios.stream()
                .filter(u -> u.getId() == id)
                .findFirst()
                .orElse(null);

        if(userBd == null){
            return false;
        }

        userBd.setNome(user.getNome());
        userBd.setSobrenome(user.getSobrenome());

        return true;
    }
}
