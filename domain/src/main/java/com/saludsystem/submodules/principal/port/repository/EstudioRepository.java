package com.saludsystem.submodules.principal.port.repository;

import com.saludsystem.submodules.principal.model.Estudio;

import java.util.UUID;

public interface EstudioRepository {
    Estudio save(Estudio estudio);
    Estudio update(UUID uuid, Estudio estudio);
    void delete(UUID uuid);
}