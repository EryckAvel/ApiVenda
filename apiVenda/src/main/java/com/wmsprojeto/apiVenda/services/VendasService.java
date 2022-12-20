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
    private ProdutoEmbalagemRepository EmbalagemRepository;
    @Autowired
    private ClientesRepository clientesRepository;
    @Autowired
    private PedidosRepository pedidosRepository;

    public List<PedidoItens> findAllByIdpedido(Long idpedido) {
        List<PedidoItens> itens = itensRepository.findAllByIdpedido(idpedido);
        itens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = EmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodBarra());
            }
        });
        return itens;
    }

    public List<PedidoItens> findAllByIdcliente(Long idcliente) {
        List<PedidoItens> itens = itensRepository.findAllByIdcliente(idcliente);
        itens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = EmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodBarra());
            }
        });
        return itens;
    }

    public List<PedidoItens> findAllByDatageracao(Date data) {
        List<PedidoItens> itens = itensRepository.findAllByDatageracao(data);
        itens.forEach(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = EmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodBarra());
            }
        });
        return itens;
    }

    public Optional<ProdutoEmbalagem> findByCodBarra(String codbarra) {
        return EmbalagemRepository.findByCodbarra(codbarra);
    }

    @Transactional
    public PedidoItens save(PedidoItens item) {
        return itensRepository.save(item);
    }

    public Optional<PedidoItens> findById(Long id) {
        return itensRepository.findById(id);
    }

    @Transactional
    public PedidoItens alterarQuantidadePedidoItem(Long id, Integer qtd){
        Optional<PedidoItens> itensOptional = itensRepository.findById(id);
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

    //FALTA FINALIZAR A PARTE DE CODBARRA
    @Transactional
    public PedidoItens alterarQuantidadePedidoItem(Long id, Integer qtd, String codbarra){
        Optional<PedidoItens> itensOptional = itensRepository.findById(id);
        itensOptional.map(pedidoItens1 -> {
            Optional<ProdutoEmbalagem> produtoEmbalagemOptional = EmbalagemRepository.findByIdProduto(pedidoItens1.getProduto().getIdproduto());
            if (produtoEmbalagemOptional.isPresent()){
                pedidoItens1.setCodbarra(produtoEmbalagemOptional.get().getCodBarra());
                codbarra.equals(pedidoItens1.getCodbarra());
            }
            return itensOptional;
        });

        Optional<ProdutoEmbalagem> itensOptional2 = EmbalagemRepository.findByCodbarra(codbarra);

        if (itensOptional.isEmpty()){
            throw new RuntimeException("item não encontrado");
        }
        /*
        if(itensOptional2.isEmpty() || !itensOptional2.equals(itensOptional.get().getCodbarra())){
            throw new RuntimeException("Codigo de Barras não encontrado!");
        }

         */


        PedidoItens itens = itensOptional.get();
        itens.setQtdSeparada(qtd);
        return save(itens);
    }

}
