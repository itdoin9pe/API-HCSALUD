package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Medida;

import java.util.UUID;

public interface MedidaRepository {
    Medida save(Medida medida);
    Medida update(UUID uuid, Medida medida);
    void delete(UUID uuid);
}