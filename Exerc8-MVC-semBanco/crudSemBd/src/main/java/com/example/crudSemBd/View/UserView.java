package com.example.crudSemBd.View;

import com.example.crudSemBd.Controller.UserController;
import com.example.crudSemBd.Model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserView {
    UserController userController = new UserController();

    @GetMapping
    public List<User> getAll(){
        return userController.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable int id){
        return userController.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody User user){
        return userController.insertBanco(user);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable int id){
        return userController.update(id, user);
    }
}