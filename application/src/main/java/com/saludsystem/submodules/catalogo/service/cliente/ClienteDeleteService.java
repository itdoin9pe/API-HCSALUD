package com.saludsystem.submodules.catalogo.service.cliente;

import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;

import java.util.UUID;

public class ClienteDeleteService {

    private final ClienteRepository clienteRepository;

    public ClienteDeleteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public void execute(UUID uuid) {
        clienteRepository.delete(uuid);
    }
}
