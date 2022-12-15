package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.PedidoItensRepository;
import com.wmsprojeto.apiVenda.repository.ProdutoEmbalagemRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoItensService {

    @Autowired
    PedidoItensRepository pedidoItensRepository;
    @Autowired
    ProdutoEmbalagemRepository produtoEmbalagemRepository;


    public List<PedidoItens> findAll() {
        List<PedidoItens> pedidoItens = pedidoItensRepository.findAll();
        pedidoItens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = produtoEmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodBarra());
            }
        });
        return pedidoItens;
    }

    public Optional<PedidoItens> findById(Long id) {
        return pedidoItensRepository.findById(id);
    }

    public PedidoItens save(PedidoItens item) {
        return pedidoItensRepository.save(item);
    }

    public Optional<PedidoItens> findByCodBarra(String codbarra) {
        Optional<PedidoItens> pedidoItens = pedidoItensRepository.findByCodBarra(codbarra);
        pedidoItens.stream().map(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = produtoEmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodBarra());
            }
            return pedidoItens;
        });
        return pedidoItens;
    }
}
