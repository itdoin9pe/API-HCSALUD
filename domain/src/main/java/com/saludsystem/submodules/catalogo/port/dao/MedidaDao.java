package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Medida;

import java.util.List;
import java.util.UUID;

public interface MedidaDao {
    Medida save(Medida medida);
    Medida update(UUID uuid, Medida medida);
    void delete(UUID uuid);
    Medida getById(UUID uuid);
    List<Medida> getAll(UUID hospitalId, int page, int rows);
}