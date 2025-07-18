package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.cliente.ClienteDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteDeleteHandler {

    private final ClienteDeleteService clienteDeleteService;

    public ClienteDeleteHandler(ClienteDeleteService clienteDeleteService) {
        this.clienteDeleteService = clienteDeleteService;
    }

    public void execute(UUID uuid) {
        clienteDeleteService.execute(uuid);
    }
}
