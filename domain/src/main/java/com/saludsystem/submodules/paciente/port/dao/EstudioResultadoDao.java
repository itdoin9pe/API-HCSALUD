package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;
import com.saludsystem.submodules.response.ListResponse;

import java.util.List;
import java.util.UUID;

public interface EstudioResultadoDao {

    EstudioResultado getById(Long id);
    ListResponse<EstudioResultado> getAll(UUID hospitalId, int page, int rows);
    List<EstudioResultado> getList();

}