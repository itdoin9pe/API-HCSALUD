package com.saludsystem.submodules.catalogo.usecase;

import com.saludsystem.submodules.catalogo.model.Cliente;
import com.saludsystem.submodules.catalogo.port.dao.ClienteDao;
import com.saludsystem.submodules.catalogo.port.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClienteUseCase implements ClienteDao {

    private final ClienteRepository clienteRepository;

    public ClienteUseCase(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(UUID uuid, Cliente cliente) {
        return clienteRepository.update(uuid, cliente);
    }

    @Override
    public void delete(UUID uuid) {
        clienteRepository.delete(uuid);
    }

    @Override
    public Cliente getById(UUID uuid) {
        return clienteRepository.findById(uuid);
    }

    @Override
    public List<Cliente> getAll(UUID hospitalId, int page, int rows) {
        return clienteRepository.findAll(hospitalId, page, rows);
    }
}