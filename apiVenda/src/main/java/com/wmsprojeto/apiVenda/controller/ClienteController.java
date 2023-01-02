package com.wmsprojeto.apiVenda.controller;

import com.wmsprojeto.apiVenda.dto.ClientesDTO;
import com.wmsprojeto.apiVenda.model.Clientes;
import com.wmsprojeto.apiVenda.dto.services.ClientesService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes")
@CrossOrigin("*")
public class ClienteController {

    @Autowired
    ClientesService clientesService;

    @GetMapping
    public ResponseEntity<List<Clientes>> listarClientes(){
        return ResponseEntity.status(HttpStatus.OK).body(clientesService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> buscarCliente(@PathVariable("id") Long id){
        Optional<Clientes> clientesOptional = clientesService.findById(id);
        if(!clientesOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(clientesOptional.get());
    }

    @PostMapping
    public ResponseEntity<Clientes> salvarcliente(@RequestBody ClientesDTO dto){
        var clientes = new Clientes();
        BeanUtils.copyProperties(dto, clientes);
        return ResponseEntity.status(HttpStatus.CREATED).body(clientesService.save(clientes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> atualizarCliente(@PathVariable("id") Long id,@RequestBody ClientesDTO dto){
        Optional<Clientes> clientesOptional = clientesService.findById(id);
        if (!clientesOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        var cliente = new Clientes();
        BeanUtils.copyProperties(dto, cliente);
        cliente.setIdcliente(clientesOptional.get().getIdcliente());
        return ResponseEntity.status(HttpStatus.OK).body(clientesService.save(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletarCliente(@PathVariable("id") Long id){
        Optional<Clientes> clientesOptional = clientesService.findById(id);
        if (!clientesOptional.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente não encontrado!");
        }
        clientesService.delete(clientesOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Cliente deletado!");
    }

}
