package com.saludsystem.submodules.principal.port.repository;

import com.saludsystem.submodules.principal.model.Estudio;

import java.util.UUID;

public interface EstudioRepository {
    Estudio save(Estudio tipoCitado);
    Estudio update(UUID uuid, Estudio tipoCitado);
    void delete(UUID uuid);
}