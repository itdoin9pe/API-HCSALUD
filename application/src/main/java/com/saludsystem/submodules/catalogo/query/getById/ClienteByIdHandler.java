package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.ClienteDTO;
import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ClienteByIdHandler {
    private final ClienteDao clienteService;

    public ClienteByIdHandler(ClienteDao clienteService) {
        this.clienteService = clienteService;
    }

    public ClienteDTO execute(UUID uuid) {
        Cliente model = clienteService.getById(uuid);
        return ClienteMapper.toDto(model);
    }
}