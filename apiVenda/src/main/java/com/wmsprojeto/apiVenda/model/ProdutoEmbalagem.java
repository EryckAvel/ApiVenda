package com.wmsprojeto.apiVenda.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "produtosembalagem")
public class ProdutoEmbalagem implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idprodutoembalagem;
    @ManyToOne
    @JoinColumn(name = "idproduto")
    private Produto produto;
    private String codbarra;
    private String embalagem;
    private Integer quantidade;
    private Integer situacao;

    public ProdutoEmbalagem() {
    }

    public ProdutoEmbalagem(Long id, Produto produto, String codbarra, String embalagem, Integer quantidade, Integer situacao) {
        this.idprodutoembalagem = id;
        this.produto = produto;
        this.codbarra = codbarra;
        this.embalagem = embalagem;
        this.quantidade = quantidade;
        this.situacao = situacao;
    }

    public Long getIdprodutoembalagem() {
        return idprodutoembalagem;
    }

    public void setIdprodutoembalagem(Long idprodutoembalagem) {
        this.idprodutoembalagem = idprodutoembalagem;
    }

    public String getCodBarra() {
        return codbarra;
    }

    public void setCodBarra(String codBarra) {
        this.codbarra = codBarra;
    }

    public String getEmbalagem() {
        return embalagem;
    }

    public void setEmbalagem(String embalagem) {
        this.embalagem = embalagem;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getSituacao() {
        return situacao;
    }

    public void setSituacao(Integer situacao) {
        this.situacao = situacao;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


}
