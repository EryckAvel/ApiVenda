package com.wmsprojeto.apiVenda.repository;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface PedidoItensRepository extends JpaRepository<PedidoItens, Long> {
    @Query("SELECT p FROM PedidoItens p WHERE p.pedidos.idpedido =:idpedido")
    List<PedidoItens> findAllByIdpedido(Long idpedido);

    @Query("SELECT p FROM PedidoItens p WHERE p.pedidos.cliente.idcliente =:idcliente")
    List<PedidoItens> findAllByIdcliente(Long idcliente);

    @Query("SELECT p FROM PedidoItens p WHERE p.pedidos.datageracao =:datageracao")
    List<PedidoItens> findAllByDatageracao(Date data);

/*
    @Query()
    PedidoItens findByCodbarra(String codBarra);


 */

    //Optional<PedidoItens> findByCodBarra(String codbarra);

    /*
    @Query("SELECT p FROM ProdutoEmbalagem p WHERE p.cliente.idcliente = 1")
    PedidoItens findByIdCliente(Long idcliente);

    List<PedidoItens> findAllByIdCliente(Long idcliente);

     */
}
