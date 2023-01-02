package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.config.exception.RegraNegocio;
import com.wmsprojeto.apiVenda.dto.PedidoItensDTO;
import com.wmsprojeto.apiVenda.dto.SalvarPedidoItensDTO;
import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.services.PedidoItensService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pedido/item")
@CrossOrigin("*")
public class PedidoItemController {

    @Autowired
    PedidoItensService pedidoItensService;

    @GetMapping
    public ResponseEntity<List<PedidoItens>> listarItensPedido(){
        return ResponseEntity.status(HttpStatus.OK).body(pedidoItensService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarItemPedido(@PathVariable("id") Long id){
        Optional<PedidoItens> pedidoItensOptional = pedidoItensService.findById(id);
        if (!pedidoItensOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidoItensOptional.get(   ));
    }

    @PostMapping
    public ResponseEntity<PedidoItens> salvarPedido(@RequestBody PedidoItensDTO dto) throws RegraNegocio {
        return pedidoItensService.salvarItenPedido(dto);
    }

    @PostMapping("/detalhes")
    public ResponseEntity<PedidoItens> salvarPedidoAtualizado(@RequestBody SalvarPedidoItensDTO dto) throws RegraNegocio {
        return pedidoItensService.salvarItenPedidoAtualizado(dto);
    }

}
