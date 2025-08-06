package com.saludsystem.submodules.paciente.port.repository.tratamiento;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.CostoTratamiento;

import java.util.UUID;

public interface CostoTratamientoRepository {
    CostoTratamiento save(CostoTratamiento costoTratamiento);
    CostoTratamiento update(UUID uuid, CostoTratamiento costoTratamiento);
    void delete(UUID uuid);
}