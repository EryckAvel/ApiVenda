package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.model.Clientes;
import com.wmsprojeto.apiVenda.services.VendasService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cliente")
public class VendasController {

    @Autowired
    VendasService vendasService;

    @GetMapping("/listar")
    public ResponseEntity<List<Clientes>> listar()
    {
        return ResponseEntity.status(HttpStatus.OK).body(vendasService.findAll());
    }


    @GetMapping("/{idcliente}")
    public ResponseEntity<Object> busca(@PathVariable Long idcliente) {
        Optional<Clientes> clientesOptional = vendasService.findById(idcliente);
        if (!clientesOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não enontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientesOptional.get());
    }


}
