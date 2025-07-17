package com.saludsystem.submodules.catalogo.port.repository;

import com.saludsystem.submodules.catalogo.model.Alergia;

import java.util.UUID;

public interface AlergiaRepository {
    Alergia save(Alergia alergia);
    Alergia update(UUID id, Alergia alergia);
    void delete(UUID id);
}