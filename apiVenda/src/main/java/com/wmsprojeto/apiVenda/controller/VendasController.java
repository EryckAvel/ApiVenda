package com.wmsprojeto.apiVenda.controller;


import com.wmsprojeto.apiVenda.dto.PedidoItensDTO;
import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.PedidoItensRepository;
import com.wmsprojeto.apiVenda.services.ProdutoEmbalagemService;
import com.wmsprojeto.apiVenda.services.VendasService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    @Autowired
    ProdutoEmbalagemService produtoEmbalagemService;

    @Autowired
    VendasService vendasService;
    @Autowired
    private PedidoItensRepository pedidoItensRepository;


    @GetMapping("item/pedido/data/{idcliente}")
    public ResponseEntity<List<PedidoItens>> consultaClienteItem(@PathVariable("idcliente") Long idcliente){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findAllByIdcliente(idcliente));
    }

    @GetMapping("/item/{idpedido}")
    public ResponseEntity<List<PedidoItens>> consultarPedidoItem(@PathVariable("idpedido") Long idpedido){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findAllByIdpedido(idpedido));
    }

    @GetMapping("/item/pedido/{data}")
    public ResponseEntity<List<PedidoItens>> consultarDataItem(@PathVariable("data") Date data){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findAllByDatageracao(data));
    }


    @GetMapping("/{codbarra}")
    public ResponseEntity<Object> busacarCodBarras(@PathVariable String codbarra){
        Optional<ProdutoEmbalagem> produtoEmbalagemOptional = produtoEmbalagemService.findByCodBarra(codbarra);
        if(!produtoEmbalagemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse codigo de barras!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoEmbalagemOptional.get().getProduto());
    }

    @PutMapping("/{id}/{codbarra}/{qtd}")
    public ResponseEntity<Object> buscarCodeSalvarqtd(
            @PathVariable("id") Long id,
            @PathVariable("codbarra") String codbarra,
            @RequestBody PedidoItensDTO dto){
        Optional<PedidoItens> pedidoItensOptional = vendasService.findByIdAndCodBarra(id);
        Optional<ProdutoEmbalagem> embalagemOptional = vendasService.findByCodbarra(codbarra);
        if(!pedidoItensOptional.isPresent() && !embalagemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse codigo de barras!");
        }
        var item = new PedidoItens();
        BeanUtils.copyProperties(dto, item);
        item.setPedidos(pedidoItensOptional.get().getPedidos());
        item.setProduto(pedidoItensOptional.get().getProduto());
        item.setQuantidade(pedidoItensOptional.get().getQuantidade());
        item.setQtdcortada(pedidoItensOptional.get().getQtdcortada());
        item.setQtdConferida(pedidoItensOptional.get().getQtdConferida());
        item.setCodbarra(pedidoItensOptional.get().getCodbarra());
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.save(item));
    }


}
