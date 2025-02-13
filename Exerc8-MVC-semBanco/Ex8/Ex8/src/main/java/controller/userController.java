package controller;

import banco.UserBd;
import model.User;

import java.util.List;

public class userController {
    
    //buscar todos
    UserBd repository = new UserBd();
    public List<User> getAll() {
        return repository.findAll();

    }
    public User getById(Long id){
        return repository.getById(id);
    }

    public boolean insert (User user){
        return repository.insert(user);
    }
    public User update(Long id, User user){
        boolean result = repository.update(id, user);
        if(result){
            return  user;
        }
        return null;
    }
}
