package com.wmsprojeto.apiVenda.dto;

import java.util.Date;

public class PedidosDTO {

    private String cliente;
    private Date datageracao;
    private Integer totalpedido;
    private Integer qtdItens;
    private String status;

    public PedidosDTO() {
    }

    public PedidosDTO(String cliente, Date datageracao, Integer totalpedido, Integer qtdItens, String status) {
        this.cliente = cliente;
        this.datageracao = datageracao;
        this.totalpedido = totalpedido;
        this.qtdItens = qtdItens;
        this.status = status;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Date getDatageracao() {
        return datageracao;
    }

    public void setDatageracao(Date datageracao) {
        this.datageracao = datageracao;
    }

    public Integer getTotalpedido() {
        return totalpedido;
    }

    public void setTotalpedido(Integer totalpedido) {
        this.totalpedido = totalpedido;
    }

    public Integer getQtdItens() {
        return qtdItens;
    }

    public void setQtdItens(Integer qtdItens) {
        this.qtdItens = qtdItens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
