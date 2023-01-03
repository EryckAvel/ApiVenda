package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.model.ProdutoEmbalagem;
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
@CrossOrigin("*")
public class VendasController {
    @Autowired
    VendasService vendasService;

/*
    @GetMapping("item/pedido/data/{idcliente}")
    public ResponseEntity<List<PedidoItens>> consultaClienteItem(@PathVariable("idcliente") Long idcliente){
        return vendasService.findAllByIdcliente(idcliente);
    }

    @GetMapping("/item/{idpedido}")
    public ResponseEntity<List<PedidoItens>> consultarPedidoItem(@PathVariable("idpedido") Long idpedido){
        return vendasService.findAllByIdpedido(idpedido);
    }

    @GetMapping("/item/pedido/{data}")
    public ResponseEntity<List<PedidoItens>> consultarDataItem(@PathVariable("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data){
        return vendasService.findAllByDatageracao(data);
    }

 */

    @GetMapping("/{codbarra}")
    public ResponseEntity<Object> busacarCodBarras(@PathVariable String codbarra){
        Optional<ProdutoEmbalagem> produtoEmbalagemOptional = vendasService.findByCodBarra(codbarra);
        if(!produtoEmbalagemOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi possivel encontrar esse codigo de barras!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(produtoEmbalagemOptional.get().getProduto());
    }

    @PutMapping("/busca/{codbarra}/{iditem}/{qtd}")
    public ResponseEntity<Object> alterarQuantidadeItemCodBarra(@PathVariable("codbarra") String codbarra,@PathVariable("iditem") Long iditem,@PathVariable("qtd") Integer qtd){
        return vendasService.alterarQuantidadePedidoItemPorCodigoBarras(codbarra, iditem, qtd);
    }

    @GetMapping("/item/{idpedido}/{data}/{idcliente}")
    public ResponseEntity<List<PedidoItens>> consultaExpecificaDeItem(@PathVariable("idpedido") Long idpedido,
                                                                      @PathVariable("data") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date data,
                                                                      @PathVariable("idcliente") Long idcliente){

        return vendasService.buscaExpecificaDeItem(idpedido, data, idcliente);

    }

}
