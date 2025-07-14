package com.saludsystem.submodules.paciente.port.in.service.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.model.historialclinico.tratamiento.CostoTratamiento;

import java.util.List;
import java.util.UUID;

public interface CostoTratamientoService {
    CostoTratamiento save(CostoTratamiento costoTratamiento);
    CostoTratamiento update(UUID uuid, CostoTratamiento costoTratamiento);
    void delete(UUID uuid);
    CostoTratamiento getById(UUID uuid);
    List<CostoTratamiento> getAll(UUID hospitalId, int page, int rows);
}