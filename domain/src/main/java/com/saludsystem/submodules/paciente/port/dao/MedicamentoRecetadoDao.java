package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.MedicamentoRecetado;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface MedicamentoRecetadoDao {
    MedicamentoRecetado getById(UUID uuid);
    ListResponse<MedicamentoRecetado> getAll(UUID hospitalId, int page, int rows);
    List<MedicamentoRecetado> getList();
}