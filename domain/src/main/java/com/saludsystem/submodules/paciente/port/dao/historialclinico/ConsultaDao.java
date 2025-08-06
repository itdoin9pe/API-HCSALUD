package com.saludsystem.submodules.paciente.port.dao.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.Consulta;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ConsultaDao {
    Consulta getById(UUID uuid);
    ListResponse<Consulta> getAll(UUID hospitalId, int page, int rows);
    List<Consulta> getList();
}