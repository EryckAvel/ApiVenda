package com.wmsprojeto.apiVenda.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clientes")
public class Clientes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idcliente;
    private String cpfCnpj;
    private String nomeCidade;
    private String endereco;
    private String complemento;
    private String numero;
    private String bairro;
    private String cep;

    public Clientes() {
    }

    public Clientes(
            Long id,
            String cpfCnpj,
            String nomeCidade,
            String endereco,
            String complemento,
            String numero,
            String bairro,
            String cep) {
        this.idcliente = id;
        this.cpfCnpj = cpfCnpj;
        this.nomeCidade = nomeCidade;
        this.endereco = endereco;
        this.complemento = complemento;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
    }

    public Long getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(Long idcliente) {
        this.idcliente = idcliente;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
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

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

}
