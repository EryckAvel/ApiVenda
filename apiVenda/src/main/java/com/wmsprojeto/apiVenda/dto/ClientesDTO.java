package com.wmsprojeto.apiVenda.dto;

public class ClientesDTO {

    private String nome;
    private String cpfcnpj;
    private String nomecidade;
    private String endereco;
    private String complemento;
    private Integer numero;
    private String cep;
    private String bairro;



    public ClientesDTO() {
    }

    public ClientesDTO(String nome, String cpfcnpj, String nomecidade, String endereco, String complemento, Integer numero, String cep, String bairro) {
        this.nome = nome;
        this.cpfcnpj = cpfcnpj;
        this.nomecidade = nomecidade;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.cep = cep;
        this.bairro = bairro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfcnpj() {
        return cpfcnpj;
    }

    public void setCpfcnpj(String cpfcnpj) {
        this.cpfcnpj = cpfcnpj;
    }

    public String getNomecidade() {
        return nomecidade;
    }

    public void setNomecidade(String nomecidade) {
        this.nomecidade = nomecidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
}
