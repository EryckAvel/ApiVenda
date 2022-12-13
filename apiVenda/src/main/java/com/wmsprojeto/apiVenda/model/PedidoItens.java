package com.wmsprojeto.apiVenda.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedidositens")
public class PedidoItens implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idpedidoitem;
    @ManyToOne
    @JoinColumn(name = "pedidos_id")
    private Pedidos pedidos;
    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private Integer quantidade;
    private Integer qtdSerparada;
    private Integer qtdConferida;
    private Integer qtdCortada;

    public PedidoItens() {
    }

    public PedidoItens(Long id, Pedidos pedidos, Produto produto, Integer quantidade, Integer qtdSerparada, Integer qtdConferida, Integer qtdCortada) {
        this.idpedidoitem = id;
        this.pedidos = pedidos;
        this.produto = produto;
        this.quantidade = quantidade;
        this.qtdSerparada = qtdSerparada;
        this.qtdConferida = qtdConferida;
        this.qtdCortada = qtdCortada;
    }

    public Long getIdpedidoitem() {
        return idpedidoitem;
    }

    public void setIdpedidoitem(Long idpedidoitem) {
        this.idpedidoitem = idpedidoitem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQtdSerparada() {
        return qtdSerparada;
    }

    public void setQtdSerparada(Integer qtdSerparada) {
        this.qtdSerparada = qtdSerparada;
    }

    public Integer getQtdConferida() {
        return qtdConferida;
    }

    public void setQtdConferida(Integer qtdConferida) {
        this.qtdConferida = qtdConferida;
    }

    public Integer getQtdCortada() {
        return qtdCortada;
    }

    public void setQtdCortada(Integer qtdCortada) {
        this.qtdCortada = qtdCortada;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

}
