package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PedidoItensRepository extends JpaRepository<PedidoItens, Long> {
    Optional<PedidoItens> findByCodBarra(String codbarra);
}
