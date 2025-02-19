package com.example.crudSemBd.Controller;

import com.example.crudSemBd.Banco.UserBd;
import com.example.crudSemBd.Model.User;

import java.util.List;

public class UserController {

    UserBd repository = new UserBd();

    public List<User> getAll(){
        return repository.findAll();
    }

    public User getById(int id){
        return repository.getById(id);
    }

    public boolean insertBanco(User user){
        return repository.insert(user);
    }

    public User update(int id, User user){
        boolean result = repository.update(id, user);

        if(result){
            return user;
        }
        return null;
    }
}
