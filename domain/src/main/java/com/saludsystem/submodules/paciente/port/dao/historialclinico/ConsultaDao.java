package com.saludsystem.submodules.paciente.port.dao.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;

import java.util.List;
import java.util.UUID;

public interface ConsultaDao {
    Consulta save(Consulta consulta);
    Consulta update(UUID uuid, Consulta consulta);
    void delete(UUID uuid);
    Consulta getById(UUID uuid);
    List<Consulta> getAll(UUID hospitalId, int page, int rows);
}