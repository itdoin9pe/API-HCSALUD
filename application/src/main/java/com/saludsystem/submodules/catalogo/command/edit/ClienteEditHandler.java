package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarClienteDTO;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteEditHandler {

    private final ClienteEditService clienteEditService;

    public ClienteEditHandler(ClienteEditService clienteEditService) {
        this.clienteEditService = clienteEditService;
    }

    public void execute(UUID uuid, ActualizarClienteDTO dto) {
        clienteEditService.execute(uuid, dto);
    }
}