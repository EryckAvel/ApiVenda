package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.Pedidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidosRepository extends JpaRepository<Pedidos, Long> {
}
