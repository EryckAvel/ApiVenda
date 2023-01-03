package com.wmsprojeto.apiVenda.dto;

public class ProdutoEmbalagemDTO {

    private String produto;
    private String codbarra;
    private String embalagem;
    private Integer quantidade;
    private Integer situacao;

    public ProdutoEmbalagemDTO() {
    }

    public ProdutoEmbalagemDTO(String produto, String codbarra, String embalagem, Integer quantidade, Integer situacao) {
        this.produto = produto;
        this.codbarra = codbarra;
        this.embalagem = embalagem;
        this.quantidade = quantidade;
        this.situacao = situacao;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getCodbarra() {
        return codbarra;
    }

    public void setCodbarra(String codbarra) {
        this.codbarra = codbarra;
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
}

