package com.saludsystem.submodules.paciente.port.repository.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;

import java.util.UUID;

public interface ConsultaRepository {
    Consulta save(Consulta consulta);
    Consulta update(UUID uuid, Consulta consulta);
    void delete(UUID uuid);
}