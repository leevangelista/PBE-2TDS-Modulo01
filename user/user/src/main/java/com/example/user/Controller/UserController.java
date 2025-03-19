package com.example.user.Controller;


import com.example.user.Entity.User;
import com.example.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User userBd = userRepository.save(user);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(userBd);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getById(@PathVariable long id) {
       Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.FOUND).body(userOptional);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateById(@PathVariable long id, @RequestBody User user){
       Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
       user.setNome(user.getNome());
       user.setEmail(user.getEmail());
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable long id, @RequestBody User user){
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()){
            userRepository.delete(user);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        }
        else{
            return null;
        }
    }

    @GetMapping
    public ResponseEntity<List<User>> getAl(){
        List<User> userList = userRepository.findAll();
        if(userList.isEmpty()){
            return ResponseEntity.status(HttpStatus.FOUND).body(userList);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

}
