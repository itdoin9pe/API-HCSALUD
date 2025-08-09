package com.saludsystem.submodules.paciente.service.historia.evolucion.altamedica;

import com.saludsystem.submodules.paciente.port.dao.evolucion.AltaMedicaDao;
import com.saludsystem.submodules.paciente.port.repository.evolucion.AltaMedicaRepository;

public class AltaMedicaDeleteService {

    private final AltaMedicaRepository altaMedicaRepository;
    private final AltaMedicaDao altaMedicaDao;

    public AltaMedicaDeleteService(AltaMedicaRepository altaMedicaRepository, AltaMedicaDao altaMedicaDao) {
        this.altaMedicaRepository = altaMedicaRepository;
        this.altaMedicaDao = altaMedicaDao;
    }

    public void execute(Long id) {

        var altaMedica = altaMedicaDao.getById(id);

        if (altaMedica.getResumenFinal() != null && altaMedica.getResumenFinal().equals(" ")) {

            throw new IllegalStateException("No se puede eliminar un alta medica vacia");

        }

        altaMedicaRepository.delete(id);

    }

}
