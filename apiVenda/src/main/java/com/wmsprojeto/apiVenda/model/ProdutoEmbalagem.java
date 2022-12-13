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
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private String codBarra;
    private String embalagem;
    private Integer quantidade;
    private Integer situacao;

    public ProdutoEmbalagem() {
    }

    public ProdutoEmbalagem(Long id, Produto produto, String codBarra, String embalagem, Integer quantidade, Integer situacao) {
        this.idprodutoembalagem = id;
        this.produto = produto;
        this.codBarra = codBarra;
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
        return codBarra;
    }

    public void setCodBarra(String codBarra) {
        this.codBarra = codBarra;
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
