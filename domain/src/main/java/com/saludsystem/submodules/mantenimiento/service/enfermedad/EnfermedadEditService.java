package com.saludsystem.submodules.mantenimiento.service.enfermedad;

import com.saludsystem.submodules.mantenimiento.model.Enfermedad;
import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;
import com.saludsystem.submodules.mantenimiento.port.repository.EnfermedadRepository;

public class EnfermedadEditService {

    private final EnfermedadDao enfermedadDao;
    private final EnfermedadRepository enfermedadRepository;

    public EnfermedadEditService(EnfermedadDao enfermedadDao, EnfermedadRepository enfermedadRepository) {
        this.enfermedadDao = enfermedadDao;
        this.enfermedadRepository = enfermedadRepository;
    }

    public Enfermedad execute(String id, Enfermedad enfermedad) {

        var currentEnfermedad = enfermedadDao.getById(id);

        if (currentEnfermedad.getEstado() != null && currentEnfermedad.getEstado() == 0) {

            throw new IllegalStateException("El tipo de enfermedad ya se encuentra desactivada");

        }

        return enfermedadRepository.update(id, enfermedad);

    }

}
