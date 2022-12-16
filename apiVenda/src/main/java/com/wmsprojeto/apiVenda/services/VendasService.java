package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.ClientesRepository;
import com.wmsprojeto.apiVenda.repository.PedidoItensRepository;
import com.wmsprojeto.apiVenda.repository.PedidosRepository;
import com.wmsprojeto.apiVenda.repository.ProdutoEmbalagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
    private ProdutoEmbalagemRepository produtoEmbalagemRepository;
    @Autowired
    private ClientesRepository clientesRepository;
    @Autowired
    private PedidosRepository pedidosRepository;

    public List<PedidoItens> findAllByIdpedido(Long idpedido) {
        return itensRepository.findAllByIdpedido(idpedido);
    }

    public List<PedidoItens> findAllByIdcliente(Long idcliente) {
        return itensRepository.findAllByIdcliente(idcliente);
    }

    public List<PedidoItens> findAllByDatageracao(Date data) {
        return itensRepository.findAllByDatageracao(data);
    }

    @Transactional
    public PedidoItens save(PedidoItens item) {
        return itensRepository.save(item);
    }

    public Optional<PedidoItens> findById(Long id) {
        return itensRepository.findById(id);
    }

    public Optional<PedidoItens> findByIdAndCodBarra(Long id) {
        Optional<PedidoItens> pedidoItens = itensRepository.findById(id);
        pedidoItens.map(itens -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = produtoEmbalagemRepository.findByIdProduto(itens.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                itens.setCodbarra(produtoEmbalagemOptional.get().getCodBarra());
            }
            return pedidoItens;
        });
        return pedidoItens;
    }

    public Optional<ProdutoEmbalagem> findByCodbarra(String codbarra) {
        return produtoEmbalagemRepository.findByCodbarra(codbarra);
    }

    /*
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

     */

}
