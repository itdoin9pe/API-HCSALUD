package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.ClienteDTO;
import com.saludsystem.application.catalogo.mapper.ClienteMapper;
import com.saludsystem.domain.catalogo.model.Cliente;
import com.saludsystem.domain.catalogo.port.in.service.ClienteService;
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