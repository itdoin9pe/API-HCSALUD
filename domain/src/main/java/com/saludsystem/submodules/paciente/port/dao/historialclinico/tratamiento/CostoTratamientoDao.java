package com.saludsystem.submodules.paciente.port.dao.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.tratamiento.CostoTratamiento;

import java.util.List;
import java.util.UUID;

public interface CostoTratamientoDao {
    CostoTratamiento save(CostoTratamiento costoTratamiento);
    CostoTratamiento update(UUID uuid, CostoTratamiento costoTratamiento);
    void delete(UUID uuid);
    CostoTratamiento getById(UUID uuid);
    List<CostoTratamiento> getAll(UUID hospitalId, int page, int rows);
}