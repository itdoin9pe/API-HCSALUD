package com.saludsystem.submodules.paciente.port.repository;

import com.saludsystem.submodules.paciente.model.entity.PacienteConsentimiento;

import java.util.UUID;

public interface PConsentimientoRepository {

    PacienteConsentimiento save(PacienteConsentimiento pacienteConsentimiento);
    PacienteConsentimiento update(UUID uuid, PacienteConsentimiento pacienteConsentimiento);
    void delete(UUID uuid);

}