package com.saludsystem.submodules.mantenimiento.command.delete;

import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadDeleteService;
import org.springframework.stereotype.Component;

@Component
public class EnfermedadDeleteHandler {

    private final EnfermedadDeleteService enfermedadDeleteService;

    public EnfermedadDeleteHandler(EnfermedadDeleteService enfermedadDeleteService) {
        this.enfermedadDeleteService = enfermedadDeleteService;
    }

    public void execute(String id) {
        enfermedadDeleteService.execute(id);
    }
}
