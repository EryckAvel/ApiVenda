package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
import com.wmsprojeto.apiVenda.repository.PedidoItensRepository;
import com.wmsprojeto.apiVenda.services.PedidoItensService;
import com.wmsprojeto.apiVenda.services.ProdutoEmbalagemService;
import com.wmsprojeto.apiVenda.services.VendasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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
    PedidoItensRepository pedidoItensRepository;

    @Autowired
    PedidoItensService pedidoItensService;


    @GetMapping("item/pedido/data/{idcliente}")
    public ResponseEntity<List<PedidoItens>> consultaClienteItem(@PathVariable("idcliente") Long idcliente){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findAllByIdcliente(idcliente));
    }

    @GetMapping("/item/{idpedido}")
    public ResponseEntity<List<PedidoItens>> consultarPedidoItem(@PathVariable("idpedido") Long idpedido){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findAllByIdpedido(idpedido));
    }

    @GetMapping("/item/pedido/{data}")
    public ResponseEntity<List<PedidoItens>> consultarDataItem(@PathVariable("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findAllByDatageracao(data));
    }

    @GetMapping("/{codbarra}")
    public ResponseEntity<Object> busacarCodBarras(@PathVariable String codbarra){
        Optional<ProdutoEmbalagem> produtoEmbalagemOptional = vendasService.findByCodBarra(codbarra);
        if(!produtoEmbalagemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse codigo de barras!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoEmbalagemOptional.get().getProduto());
    }


    @PutMapping("/{codbarra}/{id}/{qtd}")
    public ResponseEntity<Object> alterarQuantidaeItem(@PathVariable("id") Long id, @PathVariable("qtd") Integer qtd,@PathVariable("codbarra") String codbarra){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.alterarQuantidadePedidoItem(id, qtd, codbarra));
    }


    @PutMapping("/{id}/{qtd}")
    public ResponseEntity<Object> alterarQuantidaeItem(@PathVariable("id") Long id, @PathVariable("qtd") Integer qtd){
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.alterarQuantidadePedidoItem(id, qtd));
    }
}
