package com.saludsystem.submodules.paciente.port.repository.tratamiento;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;

import java.util.UUID;

public interface ProcedimientoRepository {

    Procedimiento save(Procedimiento procedimiento);
    Procedimiento update(UUID uuid, Procedimiento procedimiento);
    void delete(UUID uuid);

}