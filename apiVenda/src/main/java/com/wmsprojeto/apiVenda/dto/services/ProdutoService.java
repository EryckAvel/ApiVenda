package com.wmsprojeto.apiVenda.dto.services;

import com.wmsprojeto.apiVenda.model.Produto;
import com.wmsprojeto.apiVenda.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;
    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void delete(Produto produto) {
        produtoRepository.delete(produto);
    }
}
