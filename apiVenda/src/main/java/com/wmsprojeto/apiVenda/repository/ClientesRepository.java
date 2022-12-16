package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
