package com.saludsystem.submodules.operaciones.service.unidad;

import com.saludsystem.submodules.operaciones.model.Unidad;
import com.saludsystem.submodules.operaciones.port.repository.UnidadRepository;

public class UnidadCreateService {

    private final UnidadRepository unidadRepository;

    public UnidadCreateService(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    public Unidad execute(Unidad unidad) {

        return unidadRepository.save(unidad);

    }

}
