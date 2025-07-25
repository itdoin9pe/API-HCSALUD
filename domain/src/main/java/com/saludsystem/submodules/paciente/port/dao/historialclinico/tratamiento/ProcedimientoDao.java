package com.saludsystem.submodules.paciente.port.dao.historialclinico.tratamiento;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.tratamiento.Procedimiento;

import java.util.List;
import java.util.UUID;

public interface ProcedimientoDao {
    Procedimiento save(Procedimiento procedimiento);
    Procedimiento update(UUID uuid, Procedimiento procedimiento);
    void delete(UUID uuid);
    Procedimiento getById(UUID uuid);
    List<Procedimiento> getAll(UUID hospitalId, int page, int rows);
}