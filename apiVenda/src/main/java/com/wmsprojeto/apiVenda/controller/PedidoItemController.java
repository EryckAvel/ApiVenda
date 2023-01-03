package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.config.exception.RegraNegocio;
import com.wmsprojeto.apiVenda.dto.PedidoItensDTO;
import com.wmsprojeto.apiVenda.dto.SalvarPedidoItensDTO;
import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.repository.PedidosRepository;
import com.wmsprojeto.apiVenda.services.PedidoItensService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedido/item")
@CrossOrigin("*")
public class PedidoItemController {

    @Autowired
    PedidoItensService pedidoItensService;
    @Autowired
    private PedidosRepository pedidosRepository;

    @GetMapping
    public ResponseEntity<List<PedidoItens>> listarItensPedido(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoItensService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarItemPedido(@PathVariable("id") Long id){
        return pedidoItensService.buscarItem(id);
    }

    @PostMapping
    public ResponseEntity<PedidoItens> salvarPedido(@RequestBody PedidoItensDTO dto) throws RegraNegocio {
        return pedidoItensService.salvarItenPedido(dto);
    }

    @PostMapping("/detalhes")
    public ResponseEntity<PedidoItens> salvarPedidoAtualizado(@RequestBody SalvarPedidoItensDTO dto) throws RegraNegocio {
        return pedidoItensService.salvarItenPedidoAtualizado(dto);
    }

    @DeleteMapping("/{idpedido}/{iditen}")
    public ResponseEntity<Object> deletarPedido(@PathVariable("idpedido")Long idpedido, @PathVariable("iditen") Long iditen){
        return pedidoItensService.deletarPedido(idpedido, iditen);
    }

}
