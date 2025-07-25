package com.saludsystem.submodules.principal.port.repository;

import com.saludsystem.submodules.principal.model.Aseguradora;

import java.util.UUID;

public interface AseguradoraRepository {
    Aseguradora save(Aseguradora aseguradora);
    Aseguradora update(UUID uuid, Aseguradora aseguradora);
    void delete(UUID uuid);
}