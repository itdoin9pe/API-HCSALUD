package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteCreateService;
import org.springframework.stereotype.Component;

@Component
public class ClienteCreateHandler {

    private final ClienteCreateService clienteCreateService;

    public ClienteCreateHandler(ClienteCreateService clienteCreateService) {
        this.clienteCreateService = clienteCreateService;
    }

    public void execute(ClienteCreateCommand dto) {
        clienteCreateService.execute(dto);
    }
}
