package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.config.exception.RegraNegocio;
import com.wmsprojeto.apiVenda.dto.PedidoItensDTO;
import com.wmsprojeto.apiVenda.dto.SalvarPedidoItensDTO;
import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.model.Pedidos;
import com.wmsprojeto.apiVenda.model.Produto;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.PedidoItensRepository;
import com.wmsprojeto.apiVenda.repository.PedidosRepository;
import com.wmsprojeto.apiVenda.repository.ProdutoEmbalagemRepository;
import com.wmsprojeto.apiVenda.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoItensService {

    @Autowired
    PedidoItensRepository pedidoItensRepository;
    @Autowired
    ProdutoEmbalagemRepository EmbalagemRepository;
    @Autowired
    private PedidosRepository pedidosRepository;
    @Autowired
    private ProdutoRepository produtoRepository;


    public List<PedidoItens> findAll() {
        List<PedidoItens> pedidoItens = pedidoItensRepository.findAll();
        pedidoItens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = EmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodbarra());
            }
        });
        return pedidoItens;
    }

    public PedidoItens alterarQuantidadePedidoItem(Long id, Integer qtd){
         Optional<PedidoItens> itensOptional = findById(id);
         itensOptional.map(pedidoItens1 -> {
             Optional<ProdutoEmbalagem> produtoEmbalagemOptional = EmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
             if (produtoEmbalagemOptional.isPresent()){
                 pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodbarra());
             }
             return itensOptional;
         });
         if (itensOptional.isEmpty()){
             throw new RuntimeException("item n??o encontrado");
         }
         PedidoItens itens = itensOptional.get();
         itens.setQtdSeparada(qtd);
         return save(itens);
     }

    private PedidoItens save(PedidoItens itens) {
        return save(itens);
    }

    public Optional<PedidoItens> findById(Long id) {
        return pedidoItensRepository.findById(id);
    }

    @Transactional
    public ResponseEntity<PedidoItens> salvarItenPedido(PedidoItensDTO dto) throws RegraNegocio {
        var item = new PedidoItens();
        Long idpedido = dto.getPedidos();
        Pedidos pedidos = pedidosRepository.findById(idpedido)
                .orElseThrow(() -> new RegraNegocio("Pedido n??o encontrado!"));
        Long idproduto = dto.getProduto();
        Produto produto = produtoRepository.findById(idproduto)
                .orElseThrow(() -> new RegraNegocio("Produto n??o encontrado!"));
        BeanUtils.copyProperties(dto, item);
        item.setPedidos(pedidos);
        item.setProduto(produto);
        Optional<ProdutoEmbalagem> optionalProdutoEmbalagem = EmbalagemRepository.findByIdProduto(produto.getIdproduto());
        item.setCodbarra(optionalProdutoEmbalagem.get().getCodbarra());
        item.setQtdConferida(dto.getQtdconferida());
        item.setQtdSeparada(dto.getQtdseparada());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoItensRepository.save(item));
    }

    @Transactional
    public ResponseEntity<PedidoItens> salvarItenPedidoAtualizado(SalvarPedidoItensDTO dto) throws RegraNegocio {
        var item = new PedidoItens();
        String nomeCliente = dto.getPedidos();
        Pedidos pedidos = pedidosRepository.findByNome(nomeCliente)
                .orElseThrow(() -> new RegraNegocio("Pedido n??o encontrado!"));
        String nomeProduto = dto.getProduto();
        Produto produto = produtoRepository.findByNome(nomeProduto)
                .orElseThrow(() -> new RegraNegocio("Produto n??o encontrado!"));
        BeanUtils.copyProperties(dto, item);
        item.setPedidos(pedidos);
        item.setProduto(produto);
        Optional<ProdutoEmbalagem> optionalProdutoEmbalagem = EmbalagemRepository.findByIdProduto(produto.getIdproduto());
        item.setCodbarra(optionalProdutoEmbalagem.get().getCodbarra());
        item.setQtdConferida(dto.getQtdconferida());
        item.setQtdSeparada(dto.getQtdseparada());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidoItensRepository.save(item));
    }

    public ResponseEntity<Object> buscarItem(Long id) {
        Optional<PedidoItens> pedidoItensOptional = pedidoItensRepository.findById(id);
        if (!pedidoItensOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item n??o encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidoItensOptional.get());
    }

    @Transactional
    public ResponseEntity<Object> deletarPedido(Long idpedido, Long iditen) {
        Optional<PedidoItens> itensOptional = pedidoItensRepository.buscarItem(idpedido, iditen);
        if (itensOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Iten de pedido n??o encotrado!");
        }
        pedidoItensRepository.delete(itensOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Iten deletado!");
    }
}
