package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Cliente;

import java.util.UUID;

public interface ClienteRepository {
    Cliente save(Cliente cliente);
    Cliente update(UUID uuid, Cliente cliente);
    void delete(UUID uuid);
}