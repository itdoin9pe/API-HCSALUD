package com.saludsystem.submodules.mantenimiento.service.enfermedad;

import com.saludsystem.submodules.mantenimiento.port.service.EnfermedadRepository;

public class EnfermedadDeleteService {

    private final EnfermedadRepository enfermedadRepository;

    public EnfermedadDeleteService(EnfermedadRepository enfermedadRepository) {
        this.enfermedadRepository = enfermedadRepository;
    }

    public void execute(String id) {
        enfermedadRepository.delete(id);
    }

}
