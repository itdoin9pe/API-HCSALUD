package com.saludsystem.submodules.principal.port.dao;

import com.saludsystem.submodules.principal.model.TipoPaciente;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface TipoPacienteDao {

    TipoPaciente getById(UUID uuid);
    ListResponse<TipoPaciente> getAll(UUID hospitalId, int page, int rows);
    List<TipoPaciente> getList();

}