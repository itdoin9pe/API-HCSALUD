package com.saludsystem.submodules.catalogo.port.dao;

import com.saludsystem.submodules.catalogo.model.Alergia;

import java.util.List;
import java.util.UUID;

public interface AlergiaDao {
    Alergia save(Alergia alergia);
    Alergia update(UUID id, Alergia alergia);
    void delete(UUID id);
    Alergia getById(UUID id);
    List<Alergia> getAll(UUID hospitalId, int page, int rows);
}