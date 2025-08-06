package com.saludsystem.submodules.paciente.port.dao.tratamiento;

import com.saludsystem.submodules.paciente.model.entity.tratamiento.Procedimiento;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ProcedimientoDao {
    Procedimiento getById(UUID uuid);
    ListResponse<Procedimiento> getAll(UUID hospitalId, int page, int rows);
    List<Procedimiento> getList();
}