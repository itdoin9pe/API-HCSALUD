package com.saludsystem.domain.paciente.port.in.service.historialclinico;

import com.saludsystem.domain.paciente.model.historialclinico.Consulta;

import java.util.List;
import java.util.UUID;

public interface ConsultaService {
    Consulta save(Consulta consulta);
    Consulta update(UUID uuid, Consulta consulta);
    void delete(UUID uuid);
    Consulta getById(UUID uuid);
    List<Consulta> getAll(UUID hospitalId, int page, int rows);
}