package com.saludsystem.submodules.paciente.port.repository;

import com.saludsystem.submodules.paciente.model.entity.Diagnostico;

import java.util.UUID;

public interface DiagnosticoRepository {

    Diagnostico save(Diagnostico diagnostico);
    Diagnostico update(UUID uuid, Diagnostico diagnostico);
    void delete(UUID uuid);

}