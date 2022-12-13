package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

}
