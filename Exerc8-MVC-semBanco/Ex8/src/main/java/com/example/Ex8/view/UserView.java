package com.example.Ex8.view;

import com.example.Ex8.controller.UserController;
import com.example.Ex8.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Users")
public class UserView {

    UserController userController = new UserController();

    @GetMapping
    public List<User> getAll(){
        return userController.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable Long id){
        return userController.getById(id);
    }

    @PostMapping
    public boolean insert(@RequestBody User user){
        return userController.insert(user);
    }

    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable Long id){
        return update(user, id);
    }
}
