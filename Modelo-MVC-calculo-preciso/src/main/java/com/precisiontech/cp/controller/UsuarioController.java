package com.precisiontech.cp.controller;

import com.precisiontech.cp.entity.Usuario;
import com.precisiontech.cp.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAllUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Usuario> getUsuarioByEmail(@PathVariable String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(email);
        return usuarioOptional.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/professores")
    public List<Usuario> getProfessores() {
        return usuarioRepository.findByTipoUsuario(Usuario.TipoUsuario.valueOf("PROFESSOR"));
    }

    @GetMapping("/alunos")
    public List<Usuario> getAlunos() {
        return usuarioRepository.findByTipoUsuario(Usuario.TipoUsuario.valueOf("ALUNO"));
    }

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario) {
        Usuario createdUsuario = usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUsuario);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Usuario usuario) {

        Optional<Usuario> usuarioEncontrado = usuarioRepository.findById(usuario.getEmail());

        if (usuarioEncontrado.isPresent()
                && usuarioEncontrado.get().getEmail().equals(usuario.getEmail())
                && usuarioEncontrado.get().getSenha().equals(usuario.getSenha())) {
            return ResponseEntity.ok("{\"message:\":\"Login bem-sucedido!\"}"); // Aqui você retornaria um token de autenticação, por exemplo
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"message:\":\"credenciais inválidas!\"}");
        }
    }

    @PutMapping("/{email}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable String email, @RequestBody Usuario usuarioDetails) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(email);
        if (usuarioOptional.isPresent()) {
            Usuario usuario = usuarioOptional.get();
            usuario.setNome(usuarioDetails.getNome());
            usuario.setCurso(usuarioDetails.getCurso());
            usuario.setTipoUsuario(usuarioDetails.getTipoUsuario());
            usuario.setSenha(usuarioDetails.getSenha());
            Usuario updatedUsuario = usuarioRepository.save(usuario);
            return ResponseEntity.ok(updatedUsuario);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable String email) {
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(email);
        if (usuarioOptional.isPresent()) {
            usuarioRepository.deleteById(email);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}