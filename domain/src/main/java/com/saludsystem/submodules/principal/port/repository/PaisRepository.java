package com.saludsystem.submodules.principal.port.repository;

import com.saludsystem.submodules.principal.model.Pais;

import java.util.UUID;

public interface PaisRepository {
    Pais save(Pais pais);
    Pais update(UUID uuid, Pais pais);
    void delete(UUID uuid);
}