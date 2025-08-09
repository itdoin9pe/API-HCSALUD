package com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion;

import com.saludsystem.submodules.paciente.port.dao.evolucion.CambioCondicionDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.CambioCondicionRepository;

public class CambioCondicionDeleteService {

    private final CambioCondicionRepository cambioCondicionRepository;
    private final CambioCondicionDao cambioCondicionDao;

    public CambioCondicionDeleteService(CambioCondicionRepository cambioCondicionRepository, CambioCondicionDao cambioCondicionDao) {
        this.cambioCondicionRepository = cambioCondicionRepository;
        this.cambioCondicionDao = cambioCondicionDao;
    }

    public void execute(Long id) {

        var cambioCondicion = cambioCondicionDao.getById(id);

        if (cambioCondicion.getDescripcion() != null && cambioCondicion.getDescripcion().equals(" ")) {

            throw new IllegalStateException("No se puede eliminar un cambio de condicion vacio");

        }

        cambioCondicionRepository.delete(id);

    }

}
