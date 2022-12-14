package com.wmsprojeto.apiVenda.dto;

public class ProdutoDTO {

    private String nome;

    public ProdutoDTO() {
    }

    public ProdutoDTO(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
