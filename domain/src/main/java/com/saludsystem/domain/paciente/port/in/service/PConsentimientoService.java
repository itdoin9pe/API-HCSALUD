package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.domain.paciente.model.PacienteConsentimiento;

import java.util.List;
import java.util.UUID;

public interface PConsentimientoService {
    PacienteConsentimiento save(PacienteConsentimiento pacienteConsentimiento);
    PacienteConsentimiento update(UUID uuid, PacienteConsentimiento pacienteConsentimiento);
    void delete(UUID uuid);
    PacienteConsentimiento getById(UUID uuid);
    List<PacienteConsentimiento> getAll(UUID hospitalId, int page, int rows);
}