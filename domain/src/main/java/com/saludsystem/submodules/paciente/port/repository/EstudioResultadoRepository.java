package com.saludsystem.submodules.paciente.port.repository;

import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;

import java.util.UUID;

public interface EstudioResultadoRepository {
    EstudioResultado save(EstudioResultado estudioResultado);
    EstudioResultado update(UUID uuid, EstudioResultado estudioResultado);
    void delete(UUID uuid);
}