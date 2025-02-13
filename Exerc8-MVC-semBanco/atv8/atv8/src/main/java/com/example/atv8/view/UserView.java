package com.example.atv8.view;

import com.example.atv8.controller.UserController;
import com.example.atv8.model.User;
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
    public User getById(@PathVariable Long id){
        return userController.getById(id);
    }
    @PostMapping
    public boolean insert(@RequestBody User user){
        return userController.insert(user);
    }
    @PutMapping("/{id}")
    public User update(@RequestBody User user, @PathVariable Long id){
        return userController.update(id,user);
    }

}
