package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface PConsentimientoDao {

    PacienteConsentimiento getById(UUID uuid);
    ListResponse<PacienteConsentimiento> getAll(UUID hospitalId, int page, int rows);
    List<PacienteConsentimiento> getList();

}