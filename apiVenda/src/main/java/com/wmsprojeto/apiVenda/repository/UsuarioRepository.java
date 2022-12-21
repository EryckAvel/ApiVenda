package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
