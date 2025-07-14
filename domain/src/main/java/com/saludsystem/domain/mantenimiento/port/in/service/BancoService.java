package com.saludsystem.domain.mantenimiento.port.in.service;

import com.saludsystem.domain.mantenimiento.model.Banco;

import java.util.List;
import java.util.UUID;

public interface BancoService {
    Banco save(Banco banco);
    Banco update(UUID uuid, Banco banco);
    void delete(UUID uuid);
    Banco getById(UUID uuid);
    List<Banco> getAll(UUID hospitalId, int page, int rows);
}