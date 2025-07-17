package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteDeleteHandler {
    private final ClienteDao clienteService;

    public ClienteDeleteHandler(ClienteDao clienteService) {
        this.clienteService = clienteService;
    }

    public void execute(UUID uuid){
        clienteService.delete(uuid);
    }
}
