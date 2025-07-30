package com.saludsystem.submodules.catalogo.service.cliente;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.dto.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;

import java.util.UUID;

public class ClienteByIdService {

    private final ClienteDao clienteDao;

    public ClienteByIdService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public ClienteCreateCommand execute(UUID uuid) {
        return ClienteMapper.toDto(clienteDao.getById(uuid));
    }
}
