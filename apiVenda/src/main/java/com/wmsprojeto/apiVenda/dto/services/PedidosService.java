package com.wmsprojeto.apiVenda.dto.services;

import com.wmsprojeto.apiVenda.model.Pedidos;
import com.wmsprojeto.apiVenda.repository.PedidosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    PedidosRepository pedidosRepository;

    public ResponseEntity<List<Pedidos>> listar() {
        return ResponseEntity.status(HttpStatus.OK).body(pedidosRepository.findAll());
    }

    public ResponseEntity<Object> buscar(Long id) {
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
        if (pedidosOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pedidosOptional.get());
    }

}
