package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.ClienteDTO;
import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.in.service.ClienteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteByIdHandler {
    private final ClienteService clienteService;

    public ClienteByIdHandler(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    public ClienteDTO execute(UUID uuid) {
        Cliente model = clienteService.getById(uuid);
        return ClienteMapper.toDto(model);
    }
}