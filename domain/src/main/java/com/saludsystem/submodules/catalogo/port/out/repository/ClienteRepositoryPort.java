package com.saludsystem.submodules.catalogo.port.out.repository;

import com.saludsystem.submodules.catalogo.model.Cliente;

import java.util.List;
import java.util.UUID;

public interface ClienteRepositoryPort {
    Cliente save(Cliente cliente);
    Cliente update(UUID uuid, Cliente cliente);
    void delete(UUID uuid);
    Cliente findById(UUID uuid);
    List<Cliente> findAll(UUID hospitalId, int page, int rows);
    long countByHospitalId(UUID hospitalId);
}