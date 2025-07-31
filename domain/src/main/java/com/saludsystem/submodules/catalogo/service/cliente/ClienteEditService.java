package com.saludsystem.submodules.catalogo.service.cliente;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;

import java.util.UUID;

public class ClienteEditService {

    private final ClienteDao clienteDao;
    private final ClienteRepository clienteRepository;

    public ClienteEditService(ClienteDao clienteDao, ClienteRepository clienteRepository) {
        this.clienteDao = clienteDao;
        this.clienteRepository = clienteRepository;
    }

    public Cliente execute(UUID uuid, Cliente cliente) {

        var currentCliente = clienteDao.getById(uuid);

        if (currentCliente.getEstado() != null && currentCliente.getEstado() == 0) {
            throw new IllegalStateException("El cliente ya se encuentra desactivado");
        }

        return clienteRepository.update(uuid, cliente);

    }

}
