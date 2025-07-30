package com.saludsystem.submodules.catalogo.service.cliente;

import com.saludsystem.submodules.catalogo.mapper.ClienteMapper;
import com.saludsystem.submodules.catalogo.model.dto.ClienteCreateCommand;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;

import java.util.List;

public class ClienteListService {

    private final ClienteDao clienteDao;

    public ClienteListService(ClienteDao clienteDao) {
        this.clienteDao = clienteDao;
    }

    public List<ClienteCreateCommand> execute() {
        return clienteDao.getList().stream().map(ClienteMapper::toDto).toList();
    }
}
