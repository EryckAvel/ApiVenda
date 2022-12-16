package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.ProdutoEmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoEmbalagemService {

    @Autowired
    ProdutoEmbalagemRepository produtoEmbalagemRepository;

    public Optional<ProdutoEmbalagem> findByCodBarra(String codbarra) {
        return produtoEmbalagemRepository.findByCodbarra(codbarra);
    }

    public ProdutoEmbalagem save(ProdutoEmbalagem embalagem) {
        return produtoEmbalagemRepository.save(embalagem);
    }
}
