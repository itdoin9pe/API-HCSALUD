package com.saludsystem.domain.paciente.port.in.service;

import com.saludsystem.domain.paciente.model.Diagnostico;

import java.util.List;
import java.util.UUID;

public interface DiagnosticoService  {
    Diagnostico save(Diagnostico diagnostico);
    Diagnostico update(UUID uuid, Diagnostico diagnostico);
    void delete(UUID uuid);
    Diagnostico getById(UUID uuid);
    List<Diagnostico> getAll(UUID hospitalId, int page, int rows);
}