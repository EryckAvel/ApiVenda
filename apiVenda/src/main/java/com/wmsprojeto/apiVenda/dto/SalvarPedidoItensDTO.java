package com.wmsprojeto.apiVenda.dto;

public class SalvarPedidoItensDTO {

    private String pedidos;
    private String produto;
    private Integer quantidade;
    private Integer qtdseparada;
    private Integer qtdconferida;
    private Integer qtdcortada;


    public SalvarPedidoItensDTO() {
    }

    public SalvarPedidoItensDTO(String pedidos, String produto, Integer quantidade, Integer qtdseparada, Integer qtdconferida, Integer qtdcortada) {
        this.pedidos = pedidos;
        this.produto = produto;
        this.quantidade = quantidade;
        this.qtdseparada = qtdseparada;
        this.qtdconferida = qtdconferida;
        this.qtdcortada = qtdcortada;
    }

    public String getPedidos() {
        return pedidos;
    }

    public void setPedidos(String pedidos) {
        this.pedidos = pedidos;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
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
