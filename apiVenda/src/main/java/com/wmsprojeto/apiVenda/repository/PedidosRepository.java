package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {

}
