package com.precisiontech.cp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {

    @Id
    private String  email;
    private String nome;
    private String curso;
    private TipoUsuario tipoUsuario;
    private String senha;

    public enum TipoUsuario {
        ADMINISTRADOR,
        PROFESSOR,
        ALUNO
    }

}