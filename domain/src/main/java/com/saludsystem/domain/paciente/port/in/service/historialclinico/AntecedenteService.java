package com.saludsystem.domain.paciente.port.in.service.historialclinico;

import com.saludsystem.domain.paciente.model.historialclinico.Antecedente;

import java.util.List;
import java.util.UUID;

public interface AntecedenteService {
    Antecedente save(Antecedente antecedente);
    Antecedente update(UUID uuid, Antecedente antecedente);
    void delete(UUID uuid);
    Antecedente getById(UUID uuid);
    List<Antecedente> getAll(UUID hospitalId, int page, int rows);
}