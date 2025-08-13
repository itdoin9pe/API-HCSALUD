package com.saludsystem.submodules.paciente.port.repository.interconsulta;

import com.saludsystem.submodules.paciente.model.entity.interconsulta.Interconsulta;

import java.util.UUID;

public interface InterconsultaRepository {

    Interconsulta save(Interconsulta interconsulta);
    Interconsulta update(UUID uuid, Interconsulta interconsulta);
    void execute(UUID uuid);

}