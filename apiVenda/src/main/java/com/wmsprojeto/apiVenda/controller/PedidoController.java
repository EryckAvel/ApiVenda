package com.wmsprojeto.apiVenda.controller;

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

    /*
    @PostMapping
    public ResponseEntity<Object> salvarPedido(){

    }

     */

}
