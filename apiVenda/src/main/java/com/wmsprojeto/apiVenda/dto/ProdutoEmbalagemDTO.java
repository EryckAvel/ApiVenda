package com.wmsprojeto.apiVenda.dto;

public class ProdutoEmbalagemDTO {

    private Integer quantidade;

    public ProdutoEmbalagemDTO() {
    }

    public ProdutoEmbalagemDTO(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
}

