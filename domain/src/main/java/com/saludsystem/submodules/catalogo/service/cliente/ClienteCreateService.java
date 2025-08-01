package com.saludsystem.submodules.catalogo.service.cliente;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;

public class ClienteCreateService {

    private final ClienteRepository clienteRepository;

    public ClienteCreateService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente execute(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

}