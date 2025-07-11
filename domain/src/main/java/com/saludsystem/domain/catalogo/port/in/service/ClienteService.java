package com.saludsystem.domain.catalogo.port.in.service;

import com.saludsystem.domain.catalogo.model.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteService {
    Cliente save(Cliente cliente);
    Cliente update(UUID uuid, Cliente cliente);
    void delete(UUID uuid);
    Cliente getById(UUID uuid);
    List<Cliente> getAll(UUID hospitalId, int page, int rows);
}