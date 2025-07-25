package com.saludsystem.submodules.principal.port.repository;

import com.saludsystem.submodules.principal.model.TipoPaciente;

import java.util.UUID;

public interface TipoPacienteRepository {
    // some methods soon...
    TipoPaciente save(TipoPaciente tipoPaciente);
    TipoPaciente update(UUID uuid, TipoPaciente tipoPaciente);
    void delete(UUID uuid);

}