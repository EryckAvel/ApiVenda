package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.config.exception.RegraNegocio;
import com.wmsprojeto.apiVenda.dto.PedidosDTO;
import com.wmsprojeto.apiVenda.model.Pedidos;
import com.wmsprojeto.apiVenda.services.PedidosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

    @Autowired
    PedidosService pedidosService;

    @GetMapping
    public ResponseEntity<List<Pedidos>> listarPedidos(){
        return pedidosService.listar();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarPedido(@PathVariable("id") Long id){
        return pedidosService.buscar(id);
    }

    @PostMapping
    public ResponseEntity<Object> salvarPedido(@RequestBody PedidosDTO dto) throws RegraNegocio {
        return pedidosService.salvarPedido(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarPedido(@RequestBody PedidosDTO dto, @PathVariable("id") Long id) throws RegraNegocio {
        return pedidosService.atualizarPedido(dto, id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarPedido(@PathVariable("id") Long id){
        return pedidosService.delelarPedido(id);
    }



}
