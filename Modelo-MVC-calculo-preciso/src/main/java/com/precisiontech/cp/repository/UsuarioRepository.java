package com.precisiontech.cp.repository;

import com.precisiontech.cp.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {

    public List<Usuario> findByTipoUsuario(Usuario.TipoUsuario tipoUsuario);
}