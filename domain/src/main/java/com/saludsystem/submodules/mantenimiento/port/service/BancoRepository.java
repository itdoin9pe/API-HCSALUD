package com.saludsystem.submodules.mantenimiento.port.service;

import com.saludsystem.submodules.mantenimiento.model.Banco;

import java.util.List;
import java.util.UUID;

public interface BancoRepository {
    Banco save(Banco banco);
    Banco update(UUID uuid, Banco banco);
    void delete(UUID uuid);
    Banco getById(UUID uuid);
    List<Banco> getAll(UUID hospitalId, int page, int rows);
}