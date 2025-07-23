package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadByIdService;
import org.springframework.stereotype.Component;

@Component
public class EnfermedadByIdHandler {

    private final EnfermedadByIdService enfermedadByIdService;

    public EnfermedadByIdHandler(EnfermedadByIdService enfermedadByIdService) {
        this.enfermedadByIdService = enfermedadByIdService;
    }

    public EnfermedadDTO execute(String id) {
        return enfermedadByIdService.execute(id);
    }
}
