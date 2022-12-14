package com.wmsprojeto.apiVenda.model;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "pedidos")
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpedido;
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;
    private LocalDateTime dataregistro;
    private Integer totalpedido;
    private Integer qtditens;
    private String status;

    public Pedidos() {
    }

    public Pedidos(Long id, Clientes cliente, LocalDateTime dataRegistro, Integer totalPedido, Integer qtdItens, String status) {
        this.idpedido = id;
        this.cliente = cliente;
        this.dataregistro = dataRegistro;
        this.totalpedido = totalPedido;
        this.qtditens = qtdItens;
        this.status = status;
    }

    public Long getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Long idpedido) {
        this.idpedido = idpedido;
    }

    public LocalDateTime getDataregistro() {
        return dataregistro;
    }

    public void setDataregistro(LocalDateTime dataregistro) {
        this.dataregistro = dataregistro;
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

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

}
