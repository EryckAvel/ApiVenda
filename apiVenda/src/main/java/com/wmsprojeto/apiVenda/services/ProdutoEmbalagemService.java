package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.ProdutoEmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoEmbalagemService {

    @Autowired
    ProdutoEmbalagemRepository EmbalagemRepository;

    public List<ProdutoEmbalagem> findAll() {
        return EmbalagemRepository.findAll();
    }
}
