package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.service.cliente.ClienteCreateService;
import org.springframework.stereotype.Component;

@Component
public class ClienteCreateHandler {

    private final ClienteCreateService clienteCreateService;
    private final ClienteMapper clienteMapper;

    public ClienteCreateHandler(ClienteCreateService clienteCreateService, ClienteMapper clienteMapper) {
        this.clienteCreateService = clienteCreateService;
        this.clienteMapper = clienteMapper;
    }

    public void execute(ClienteCreateCommand dto) {

        var cliente = clienteMapper.fromCreateDTO(dto);

        clienteCreateService.execute(cliente);

    }

}
