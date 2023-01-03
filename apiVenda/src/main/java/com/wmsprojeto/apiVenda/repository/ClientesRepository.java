package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ClientesRepository extends JpaRepository<Clientes, Long> {

    @Query("SELECT c FROM Clientes c WHERE c.nome=:nomeCliente")
    Optional<Clientes> findByNome(String nomeCliente);
}
