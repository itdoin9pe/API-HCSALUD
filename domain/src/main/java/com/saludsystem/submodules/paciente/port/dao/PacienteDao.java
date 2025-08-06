package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.Paciente;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;

import java.util.UUID;

public interface PacienteDao {

    Paciente getById(UUID uuid);
    ListResponse<Paciente> getAll(UUID hospitalId, int page, int rows);
    List<Paciente> getList();

}