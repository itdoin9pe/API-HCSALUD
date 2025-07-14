package com.saludsystem.domain.paciente.port.in.service.historialclinico.tratamiento;

import com.saludsystem.domain.paciente.model.historialclinico.tratamiento.Procedimiento;

import java.util.List;
import java.util.UUID;

public interface ProcedimientoService {
    Procedimiento save(Procedimiento procedimiento);
    Procedimiento update(UUID uuid, Procedimiento procedimiento);
    void delete(UUID uuid);
    Procedimiento getById(UUID uuid);
    List<Procedimiento> getAll(UUID hospitalId, int page, int rows);
}