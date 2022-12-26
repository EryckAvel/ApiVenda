package com.wmsprojeto.apiVenda.dto;

import com.wmsprojeto.apiVenda.model.Clientes;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.Date;

public class PedidoDTO {

    private Clientes clientes;
    private Date datageracao;
    private Integer totalpedido;
    private Integer qtditens;
    private String status;

    public Clientes getClientes() {
        return clientes;
    }

    public void setClientes(Clientes clientes) {
        this.clientes = clientes;
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

    public Integer getQtditens() {
        return qtditens;
    }

    public void setQtditens(Integer qtditens) {
        this.qtditens = qtditens;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
