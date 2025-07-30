package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteByIdHandler {

    private final ClienteByIdService clienteByIdService;

    public ClienteByIdHandler(ClienteByIdService clienteByIdService) {
        this.clienteByIdService = clienteByIdService;
    }

    public ClienteCreateCommand execute(UUID uuid) {
        return clienteByIdService.execute(uuid);
    }
}