package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.in.service.ClienteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteDeleteHandler {
    private final ClienteService clienteService;

    public ClienteDeleteHandler(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(UUID uuid){
        clienteService.delete(uuid);
    }
}
