package com.wmsprojeto.apiVenda.dto;

import com.wmsprojeto.apiVenda.model.Pedidos;
import com.wmsprojeto.apiVenda.model.Produto;

public class PedidoItensDTO {

    private Pedidos pedidos;
    private Produto produto;
    private Integer quantidade;
    private Integer qtdseparada;
    private Integer qtdconferida;
    private Integer qtdcortada;

    /*
    @JsonProperty("idproduto")
    private void unpackNested(Integer id) {
        this. = new Flight();
        flight.setFlight_id(flight_id);
    }
     */

    public PedidoItensDTO() {
    }

    public PedidoItensDTO(Pedidos pedidos, Produto produto, Integer quantidade, Integer qtdseparada, Integer qtdconferida, Integer qtdcortada) {
        this.pedidos = pedidos;
        this.produto = produto;
        this.quantidade = quantidade;
        this.qtdseparada = qtdseparada;
        this.qtdconferida = qtdconferida;
        this.qtdcortada = qtdcortada;
    }

    public Pedidos getPedidos() {
        return pedidos;
    }

    public void setPedidos(Pedidos pedidos) {
        this.pedidos = pedidos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
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
