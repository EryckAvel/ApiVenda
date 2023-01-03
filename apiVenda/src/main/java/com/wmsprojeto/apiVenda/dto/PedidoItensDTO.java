package com.wmsprojeto.apiVenda.dto;

public class PedidoItensDTO {

    private Long pedidos;
    private Long produto;
    private Integer quantidade;
    private Integer qtdseparada;
    private Integer qtdconferida;
    private Integer qtdcortada;


    public PedidoItensDTO() {
    }

    public PedidoItensDTO(Long pedidos, Long produto, Integer quantidade, Integer qtdseparada, Integer qtdconferida, Integer qtdcortada) {
        this.pedidos = pedidos;
        this.produto = produto;
        this.quantidade = quantidade;
        this.qtdseparada = qtdseparada;
        this.qtdconferida = qtdconferida;
        this.qtdcortada = qtdcortada;
    }

    public Long getPedidos() {
        return pedidos;
    }

    public void setPedidos(Long pedidos) {
        this.pedidos = pedidos;
    }

    public Long getProduto() {
        return produto;
    }

    public void setProduto(Long produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQtdseparada() {
        return qtdseparada;
    }

    public void setQtdseparada(Integer qtdseparada) {
        this.qtdseparada = qtdseparada;
    }

    public Integer getQtdconferida() {
        return qtdconferida;
    }

    public void setQtdconferida(Integer qtdconferida) {
        this.qtdconferida = qtdconferida;
    }

    public Integer getQtdcortada() {
        return qtdcortada;
    }

    public void setQtdcortada(Integer qtdcortada) {
        this.qtdcortada = qtdcortada;
    }

}
