package com.saludsystem.domain.principal.port.in.service;

import com.saludsystem.domain.principal.model.TipoPaciente;

import java.util.List;
import java.util.UUID;

public interface TipoPacienteService {

    TipoPaciente save(TipoPaciente tipoPaciente);
    TipoPaciente update(UUID uuid, TipoPaciente tipoPaciente);
    void delete(UUID uuid);
    TipoPaciente getById(UUID uuid);
    List<TipoPaciente> getAll(UUID hospitalId, int page, int rows);

}