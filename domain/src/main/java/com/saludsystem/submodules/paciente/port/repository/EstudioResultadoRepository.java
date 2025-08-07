package com.saludsystem.submodules.paciente.port.repository;

import com.saludsystem.submodules.paciente.model.entity.EstudioResultado;

public interface EstudioResultadoRepository {
    EstudioResultado save(EstudioResultado estudioResultado);
    EstudioResultado update(Long id, EstudioResultado estudioResultado);
    void delete(Long id);
}