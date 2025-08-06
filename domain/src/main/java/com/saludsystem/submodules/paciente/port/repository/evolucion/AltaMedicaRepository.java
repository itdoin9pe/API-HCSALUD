package com.saludsystem.submodules.paciente.port.repository.evolucion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.AltaMedica;

public interface AltaMedicaRepository {
    AltaMedica save(AltaMedica altaMedica);
    AltaMedica update(Long id, AltaMedica altaMedica);
    void delete(Long id);
}