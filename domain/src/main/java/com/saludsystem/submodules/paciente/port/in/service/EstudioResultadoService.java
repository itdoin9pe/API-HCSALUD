package com.saludsystem.submodules.paciente.port.in.service;

import com.saludsystem.submodules.paciente.model.EstudioResultado;

import java.util.List;
import java.util.UUID;

public interface EstudioResultadoService {

    EstudioResultado save(EstudioResultado estudioResultado);
    EstudioResultado update(UUID uuid, EstudioResultado estudioResultado);
    void delete(UUID uuid);
    EstudioResultado getById(UUID uuid);
    List<EstudioResultado> getAll(UUID hospitalId, int page, int rows);

}