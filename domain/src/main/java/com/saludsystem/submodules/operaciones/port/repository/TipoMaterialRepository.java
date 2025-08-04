package com.saludsystem.submodules.operaciones.port.repository;

import com.saludsystem.submodules.operaciones.model.TipoMaterial;

import java.util.UUID;

public interface TipoMaterialRepository {

    TipoMaterial save(TipoMaterial tipoMaterial);
    TipoMaterial update(UUID uuid, TipoMaterial tipoMaterial);
    void delete(UUID uuid);

}