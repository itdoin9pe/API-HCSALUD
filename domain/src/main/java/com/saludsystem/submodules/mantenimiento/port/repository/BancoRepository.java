package com.saludsystem.submodules.mantenimiento.port.repository;

import com.saludsystem.submodules.mantenimiento.model.Banco;

import java.util.UUID;

public interface BancoRepository {
    Banco save(Banco banco);
    Banco update(UUID uuid, Banco banco);
    void delete(UUID uuid);
}