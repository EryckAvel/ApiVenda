package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByLogin(String login);

    @Query("SELECT u FROM Usuario u WHERE u.email=:email")
    Optional<Usuario> buscarEmail(String email);
}
