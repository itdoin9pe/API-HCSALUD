package com.saludsystem.submodules.catalogo.port.in.service;

import com.saludsystem.submodules.catalogo.model.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    Cliente save(Cliente cliente);
    Cliente update(UUID uuid, Cliente cliente);
    void delete(UUID uuid);
    Cliente getById(UUID uuid);
    List<Cliente> getAll(UUID hospitalId, int page, int rows);
}