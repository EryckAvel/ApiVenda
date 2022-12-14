package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.PedidoItens;
import com.wmsprojeto.apiVenda.repository.PedidoItensRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoItensService {

    @Autowired
    PedidoItensRepository pedidoItensRepository;

    public List<PedidoItens> findAll() {
        return pedidoItensRepository.findAll();
    }

    public Optional<PedidoItens> findById(Long id) {
        return pedidoItensRepository.findById(id);
    }

    public PedidoItens save(PedidoItens item) {
        return pedidoItensRepository.save(item);
    }
}
