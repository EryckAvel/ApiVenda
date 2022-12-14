package com.wmsprojeto.apiVenda.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "pedidositem")
public class PedidoItens implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpedidoitem;
    @ManyToOne
    @JoinColumn(name = "idpedido")
    private Pedidos pedidos;
    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;
    private Integer quantidade;
    private Integer qtdserparada;
    private Integer qtdconferida;
    private Integer qtdcortada;

    public PedidoItens() {
    }

    public PedidoItens(Long id, Pedidos pedidos, Produto produto, Integer quantidade, Integer qtdserparada, Integer qtdconferida, Integer qtdcortada) {
        this.idpedidoitem = id;
        this.pedidos = pedidos;
        this.produto = produto;
        this.quantidade = quantidade;
        this.qtdserparada = qtdserparada;
        this.qtdconferida = qtdconferida;
        this.qtdcortada = qtdcortada;
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
        return qtdserparada;
    }

    public void setQtdSerparada(Integer qtdSerparada) {
        this.qtdserparada = qtdSerparada;
    }

    public Integer getQtdConferida() {
        return qtdconferida;
    }

    public void setQtdConferida(Integer qtdConferida) {
        this.qtdconferida = qtdConferida;
    }

    public Integer getQtdcortada() {
        return qtdcortada;
    }

    public void setQtdcortada(Integer qtdcortada) {
        this.qtdcortada = qtdcortada;
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
