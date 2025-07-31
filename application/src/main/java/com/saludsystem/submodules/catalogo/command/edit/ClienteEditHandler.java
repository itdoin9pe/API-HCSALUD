package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ClienteEditCommand;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteEditHandler {

    private final ClienteEditService clienteEditService;
    private final ClienteMapper clienteMapper;

    public ClienteEditHandler(ClienteEditService clienteEditService, ClienteMapper clienteMapper) {
        this.clienteEditService = clienteEditService;
        this.clienteMapper = clienteMapper;
    }

    public void execute(UUID uuid, ClienteEditCommand dto) {

        var cliente = clienteMapper.fromUpdateDTO(uuid, dto);

        clienteEditService.execute(uuid, cliente);

    }

}