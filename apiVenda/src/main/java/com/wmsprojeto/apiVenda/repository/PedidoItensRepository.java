package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoItensRepository extends JpaRepository<PedidoItens, Long> {
}
