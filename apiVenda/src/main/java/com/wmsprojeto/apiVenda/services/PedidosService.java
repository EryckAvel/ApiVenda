package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.config.exception.RegraNegocio;
import com.wmsprojeto.apiVenda.dto.PedidosDTO;
import com.wmsprojeto.apiVenda.model.Clientes;
import com.wmsprojeto.apiVenda.model.Pedidos;
import com.wmsprojeto.apiVenda.repository.ClientesRepository;
import com.wmsprojeto.apiVenda.repository.PedidosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PedidosService {

    @Autowired
    PedidosRepository pedidosRepository;
    @Autowired
    ClientesRepository clientesRepository;

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

    public ResponseEntity<Object> salvarPedido(PedidosDTO dto) throws RegraNegocio {
        var pedido = new Pedidos();
        BeanUtils.copyProperties(dto, pedido);
        String nomeCliente = dto.getCliente();
        Clientes cliente = clientesRepository.findByNome(nomeCliente)
                .orElseThrow(() -> new RegraNegocio("Cliente não encontrado"));
        pedido.setCliente(cliente);
        pedido.setDatageracao(Date.from(Instant.now()));
        pedido.setQtditens(dto.getQtdItens());
        return ResponseEntity.status(HttpStatus.CREATED).body(pedidosRepository.save(pedido));
    }

    public ResponseEntity<Object> atualizarPedido(PedidosDTO dto, Long id) throws RegraNegocio {
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
        if (pedidosOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado!");
        }
        var pedido = new Pedidos();
        BeanUtils.copyProperties(dto, pedido);
        pedido.setIdpedido(pedidosOptional.get().getIdpedido());
        String nomeCliente = dto.getCliente();
        Clientes cliente = clientesRepository.findByNome(nomeCliente)
                .orElseThrow(() -> new RegraNegocio("Cliente não encontrado"));
        pedido.setCliente(cliente);
        pedido.setDatageracao(pedidosOptional.get().getDatageracao());
        pedido.setQtditens(dto.getQtdItens());
        return ResponseEntity.status(HttpStatus.OK).body(pedidosRepository.save(pedido));
    }

    public ResponseEntity<Object> delelarPedido(Long id) {
        Optional<Pedidos> pedidosOptional = pedidosRepository.findById(id);
        if (pedidosOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pedido não encontrado!");
        }
        pedidosRepository.delete(pedidosOptional.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Pedido deletado!");
    }
}
