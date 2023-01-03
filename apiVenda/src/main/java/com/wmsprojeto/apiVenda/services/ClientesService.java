package com.wmsprojeto.apiVenda.services;

import com.wmsprojeto.apiVenda.model.Clientes;
import com.wmsprojeto.apiVenda.repository.ClientesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    ClientesRepository clientesRepository;

    public List<Clientes> findAll() {
        return clientesRepository.findAll();
    }


    public Optional<Clientes> findById(Long id) {
        return clientesRepository.findById(id);
    }

    @Transactional
    public Clientes save(Clientes clientes) {
        return clientesRepository.save(clientes);
    }

    @Transactional
    public void delete(Clientes clientes) {
        clientesRepository.delete(clientes);
    }
}
