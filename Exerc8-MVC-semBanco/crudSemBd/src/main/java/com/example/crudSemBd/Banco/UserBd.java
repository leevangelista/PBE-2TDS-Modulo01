package com.example.crudSemBd.Banco;

import com.example.crudSemBd.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserBd {
    private List<User> users;

    public UserBd(){
        this.users = new ArrayList<>();
    }

    // busca todos os usuário
    public List<User> findAll(){
        return new ArrayList<>(users);
    }

    // busca um user
    public User getById(int id){
        return users.stream()
                .filter(d -> d.getId() == id)
                .findFirst()
                .orElse(null);
    }

    // insere o user
    public boolean insert(User user){
        users.add(user);
        return true;
    }

    // atualiza o funcionário com base no id
    public boolean update(int id, User user){
        User userBd = users.stream()
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
