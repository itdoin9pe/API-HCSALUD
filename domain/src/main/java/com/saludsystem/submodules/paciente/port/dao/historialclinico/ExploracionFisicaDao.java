package com.saludsystem.submodules.paciente.port.dao.historialclinico;

import com.saludsystem.submodules.paciente.model.entity.historialclinico.ExploracionFisica;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface ExploracionFisicaDao {
    ExploracionFisica getById(UUID uuid);
    ListResponse<ExploracionFisica> getAll(UUID hospitalId, int page, int rows);
    List<ExploracionFisica> getList();
}