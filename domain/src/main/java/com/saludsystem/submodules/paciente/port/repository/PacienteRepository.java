package com.saludsystem.submodules.paciente.port.repository;

import com.saludsystem.submodules.paciente.model.entity.Paciente;

import java.util.UUID;

public interface PacienteRepository {

    Paciente save(Paciente paciente);
    Paciente update(UUID uuid, Paciente paciente);
    void delete(UUID uuid);

}