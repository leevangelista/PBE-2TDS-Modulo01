package com.example.Ex8.controller;

import com.example.Ex8.banco.UserBd;
import com.example.Ex8.model.User;

import java.util.List;

public class UserController {

    UserBd repository = new UserBd();

    //Busca todos
    public List<User> getAll(){
        return repository.findAll();
    }

    public User getById(Long id){
        return repository.getById(id);
    }

    public boolean insert(User user){
        return repository.insert(user);
    }

    public User update(Long id, User user){
        boolean result = repository.update(id, user);

        if (result){
            return user;
        }

        return null;
    }
}
