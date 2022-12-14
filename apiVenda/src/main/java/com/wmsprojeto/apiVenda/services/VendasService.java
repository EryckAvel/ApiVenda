package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VendasService {

    @Autowired
    PedidoItensRepository itensRepository;
    @Autowired
    ProdutoEmbalagemRepository embalagemRepository;

    public ResponseEntity<List<PedidoItens>> findAllByIdpedido(Long idpedido) {
        List<PedidoItens> itens = itensRepository.findAllByIdpedido(idpedido);
        itens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = embalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodbarra());
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body(itens);
    }

    public ResponseEntity<List<PedidoItens>> findAllByIdcliente(Long idcliente) {
        List<PedidoItens> itens = itensRepository.findAllByIdcliente(idcliente);
        itens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = embalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodbarra());
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body(itens);
    }

    public ResponseEntity<List<PedidoItens>> findAllByDatageracao(Date data) {
        List<PedidoItens> itens = itensRepository.findAllByDatageracao(data);
        itens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = embalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodbarra());
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body(itens);
    }

    public Optional<ProdutoEmbalagem> findByCodBarra(String codbarra) {
        return embalagemRepository.findByCodbarra(codbarra);
    }

    @Transactional
    public ResponseEntity<Object> alterarQuantidadePedidoItemPorCodigoBarras(String codbarra, Long id,Integer qtd){
        Optional<ProdutoEmbalagem> embalagemOptional = embalagemRepository.findByCodbarra(codbarra);
        if (embalagemOptional.isEmpty()){
            //throw new RuntimeException("Produto n??o encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto n??o encontrado!");
        }
        Optional<PedidoItens> itensOptional =  itensRepository.findByIdprodutoAndId(embalagemOptional.get().getProduto().getIdproduto(), id);
        if (itensOptional.isEmpty()){
            //throw new RuntimeException("Item com esse produto n??o encontrado!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item com esse produto n??o encontrado!");
        }
        itensOptional.map(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = embalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodbarra());
            }
            return itensOptional;
        });
        PedidoItens itens = itensOptional.get();
        itens.setQtdSeparada(qtd);
        return ResponseEntity.status(HttpStatus.OK).body(itensRepository.save(itens));
    }

    public ResponseEntity<List<PedidoItens>> buscaExpecificaDeItem(Long idpedido, Date data, Long idcliente) {
        List<PedidoItens> itens = itensRepository.findAllExpecifico(idpedido, data, idcliente);
        itens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = embalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodbarra());
            }
        });
        return ResponseEntity.status(HttpStatus.OK).body(itens);
    }
}
