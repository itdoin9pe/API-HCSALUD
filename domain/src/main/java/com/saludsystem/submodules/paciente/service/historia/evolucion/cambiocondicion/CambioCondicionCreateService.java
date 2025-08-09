package com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion;

import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;
import com.saludsystem.submodules.paciente.port.repository.evolucion.CambioCondicionRepository;

public class CambioCondicionCreateService {

    private final CambioCondicionRepository cambioCondicionRepository;

    public CambioCondicionCreateService(CambioCondicionRepository cambioCondicionRepository) {
        this.cambioCondicionRepository = cambioCondicionRepository;
    }

    public CambioCondicion execute(CambioCondicion cambioCondicion) {

        return cambioCondicionRepository.save(cambioCondicion);

    }

}
