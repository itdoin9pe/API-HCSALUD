package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.in.service.ClienteService;
import com.saludsystem.submodules.catalogo.port.out.repository.ClienteRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteUseCase implements ClienteService {

    private final ClienteRepositoryPort clienteRepositoryPort;

    public ClienteUseCase(ClienteRepositoryPort clienteRepositoryPort) {
        this.clienteRepositoryPort = clienteRepositoryPort;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepositoryPort.save(cliente);
    }

    @Override
    public Cliente update(UUID uuid, Cliente cliente) {
        return clienteRepositoryPort.update(uuid, cliente);
    }

    @Override
    public void delete(UUID uuid) {
        clienteRepositoryPort.delete(uuid);
    }

    @Override
    public Cliente getById(UUID uuid) {
        return clienteRepositoryPort.findById(uuid);
    }

    @Override
    public List<Cliente> getAll(UUID hospitalId, int page, int rows) {
        return clienteRepositoryPort.findAll(hospitalId, page, rows);
    }
}