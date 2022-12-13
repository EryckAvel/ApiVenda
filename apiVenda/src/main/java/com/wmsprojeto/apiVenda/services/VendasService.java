package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.Clientes;
import com.wmsprojeto.apiVenda.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendasService {

    @Autowired
    ClientesRepository clientesRepository;
    public Optional<Clientes> findById(Long idcliente) {
        return clientesRepository.findById(idcliente);
    }


    public List<Clientes> findAll() {
        return clientesRepository.findAll();
    }
}
