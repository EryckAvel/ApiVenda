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

    @Query(value = "SELECT p FROM PedidoItens p WHERE p.pedidos.datageracao =:datageracao")
    List<PedidoItens> findAllByDatageracao(Date datageracao);

    @Query("SELECT p FROM PedidoItens p WHERE p.produto.idproduto=:idproduto AND p.idpedidoitem =:idpedidoitem")
    Optional<PedidoItens> findByIdprodutoAndId(Long idproduto, Long idpedidoitem);

    @Query("SELECT p FROM PedidoItens p WHERE p.pedidos.idpedido=:idpedido AND p.pedidos.datageracao=:data AND p.pedidos.cliente.idcliente=:idcliente")
    List<PedidoItens> findAllExpecifico(Long idpedido, Date data, Long idcliente);
}
