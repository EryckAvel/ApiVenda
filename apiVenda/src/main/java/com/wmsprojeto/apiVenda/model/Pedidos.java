package com.wmsprojeto.apiVenda.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "pedidos")
public class Pedidos implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idpedido;
    //@JsonIgnore
    @JsonIdentityReference
    @ManyToOne
    @JoinColumn(name = "idcliente")
    private Clientes cliente;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.TIMESTAMP)
    private Date datageracao;
    private Integer totalpedido;
    private Integer qtditens;
    private String status;

    public Pedidos() {
    }

    public Pedidos(Long id, Clientes cliente, Date dataRegistro, Integer totalPedido, Integer qtdItens, String status) {
        this.idpedido = id;
        this.cliente = cliente;
        this.datageracao = dataRegistro;
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

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

}
