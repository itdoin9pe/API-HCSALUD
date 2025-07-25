package com.saludsystem.submodules.paciente.port.dao;

import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;

import java.util.List;
import java.util.UUID;

public interface EstudioResultadoDao {

    EstudioResultado save(EstudioResultado estudioResultado);
    EstudioResultado update(UUID uuid, EstudioResultado estudioResultado);
    void delete(UUID uuid);
    EstudioResultado getById(UUID uuid);
    List<EstudioResultado> getAll(UUID hospitalId, int page, int rows);

}