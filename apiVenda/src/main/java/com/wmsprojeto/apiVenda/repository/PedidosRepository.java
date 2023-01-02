package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

    @Query("SELECT p FROM Pedidos p WHERE p.cliente.nome=:nome")
    Optional<Pedidos> findByNome(String nome);
}
