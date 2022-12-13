package com.wmsprojeto.apiVenda.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long idpedido;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;
    private LocalDateTime dataRegistro;
    private Integer totalPedido;
    private Integer qtdItens;
    private String status;

    public Pedidos() {
    }

    public Pedidos(Long id, Clientes cliente, LocalDateTime dataRegistro, Integer totalPedido, Integer qtdItens, String status) {
        this.idpedido = id;
        this.cliente = cliente;
        this.dataRegistro = dataRegistro;
        this.totalPedido = totalPedido;
        this.qtdItens = qtdItens;
        this.status = status;
    }

    public Long getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Long idpedido) {
        this.idpedido = idpedido;
    }

    public LocalDateTime getDataRegistro() {
        return dataRegistro;
    }

    public void setDataRegistro(LocalDateTime dataRegistro) {
        this.dataRegistro = dataRegistro;
    }

    public Integer getTotalPedido() {
        return totalPedido;
    }

    public void setTotalPedido(Integer totalPedido) {
        this.totalPedido = totalPedido;
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

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

}
