package com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion;

import com.saludsystem.submodules.paciente.model.constant.evolucion.CambioCondicionConstant;
import com.saludsystem.submodules.paciente.model.entity.evolucion.CambioCondicion;
import com.saludsystem.submodules.paciente.port.dao.evolucion.CambioCondicionDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.CambioCondicionRepository;

public class CambioCondicionEditService {

    private final CambioCondicionDao cambioCondicionDao;
    private final CambioCondicionRepository cambioCondicionRepository;

    public CambioCondicionEditService(CambioCondicionDao cambioCondicionDao, CambioCondicionRepository cambioCondicionRepository) {
        this.cambioCondicionDao = cambioCondicionDao;
        this.cambioCondicionRepository = cambioCondicionRepository;
    }

    public CambioCondicion execute(Long id, CambioCondicion cambioCondicion) {

        var currentCambioCondicion = cambioCondicionDao.getById(id);

        if (currentCambioCondicion == null) {

            throw new IllegalArgumentException(CambioCondicionConstant.INVALID_ID);

        }

        if (currentCambioCondicion.getDescripcion() != null && currentCambioCondicion.getDescripcion().equals(" ")) {

            throw new IllegalStateException("El cambio de condicion no esta detallado");

        }

        return cambioCondicionRepository.update(id, cambioCondicion);

    }

}
