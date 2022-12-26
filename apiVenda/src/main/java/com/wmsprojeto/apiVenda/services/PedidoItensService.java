package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.PedidoItensRepository;
import com.wmsprojeto.apiVenda.repository.ProdutoEmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoItensService {

    @Autowired
    PedidoItensRepository pedidoItensRepository;
    @Autowired
    ProdutoEmbalagemRepository EmbalagemRepository;


    public List<PedidoItens> findAll() {
        List<PedidoItens> pedidoItens = pedidoItensRepository.findAll();
        pedidoItens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = EmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodBarra());
            }
        });
        return pedidoItens;
    }

    public PedidoItens alterarQuantidadePedidoItem(Long id, Integer qtd){
         Optional<PedidoItens> itensOptional = findById(id);
         itensOptional.map(pedidoItens1 -> {
             Optional<ProdutoEmbalagem> produtoEmbalagemOptional = EmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
             if (produtoEmbalagemOptional.isPresent()){
                 pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodBarra());
             }
             return itensOptional;
         });
         if (itensOptional.isEmpty()){
             throw new RuntimeException("item não encontrado");
         }
         PedidoItens itens = itensOptional.get();
         itens.setQtdSeparada(qtd);
         return save(itens);
     }

    public Optional<PedidoItens> findById(Long id) {
        return pedidoItensRepository.findById(id);
    }

    public PedidoItens save(PedidoItens item) {

        return pedidoItensRepository.save(item);
    }

}
