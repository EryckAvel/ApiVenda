package com.wmsprojeto.apiVenda.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idproduto;
    private String nome;

    public Produto() {
    }



    public Long getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(Long idproduto) {
        this.idproduto = idproduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
