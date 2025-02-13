package com.example.Exerc6;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private List<User> user = new ArrayList<>();

    @GetMapping
        public List<User> getAllUsers() {
            return user;
        }

    @GetMapping("/{id}")
    @Operation(description = "Primeiro retorno")
    public User getUserById(@PathVariable int id){
        return user.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    @PostMapping
    public User createUser(@RequestBody User newUser) {
        user.add(newUser);
        return newUser;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User updatedUser) {
        return user.stream()
                .filter(user -> user.getId() == id)
                .findFirst()
                .map(existingUser -> {
                    existingUser.setNome(updatedUser.getNome());
                    return existingUser;
                })
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado!"));
    }

    // Outra funcao de put contendo validações
//    @PutMapping("/{id}")
//    public ResponseEntity<User> updateUser(@RequestBody User updateUser, @PathVariable int id){
//        User existeUser = user.stream()
//                .filter(usuario -> usuario.getId() == id)
//                .findFirst()
//                .orElse(null);
//        if (existeUser == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        existeUser.setNome(updateUser.getNome());
//        existeUser.setCurso(updateUser.getCurso());
//
//        return ResponseEntity.ok(existeUser);
//    }
}
