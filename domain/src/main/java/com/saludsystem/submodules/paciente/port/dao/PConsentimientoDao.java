package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;

import java.util.List;
import java.util.UUID;

public interface PConsentimientoDao {
    PacienteConsentimiento save(PacienteConsentimiento pacienteConsentimiento);
    PacienteConsentimiento update(UUID uuid, PacienteConsentimiento pacienteConsentimiento);
    void delete(UUID uuid);
    PacienteConsentimiento getById(UUID uuid);
    List<PacienteConsentimiento> getAll(UUID hospitalId, int page, int rows);
}