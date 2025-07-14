package com.saludsystem.domain.operaciones.port.in.service;

import com.saludsystem.domain.operaciones.model.TipoMaterial;

import java.util.List;
import java.util.UUID;

public interface TipoMaterialService {
    TipoMaterial save(TipoMaterial tipoMaterial);
    TipoMaterial update(UUID uuid, TipoMaterial tipoMaterial);
    void delete(UUID uuid);
    TipoMaterial getById(UUID uuid);
    List<TipoMaterial> getAll(UUID hospitalId, int page, int rows);
}