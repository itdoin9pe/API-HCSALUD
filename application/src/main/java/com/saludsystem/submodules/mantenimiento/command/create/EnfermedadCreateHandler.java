package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.dtos.post.CrearEnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadCreateService;
import org.springframework.stereotype.Component;

@Component
public class EnfermedadCreateHandler {

    private final EnfermedadCreateService enfermedadCreateService;

    public EnfermedadCreateHandler(EnfermedadCreateService enfermedadCreateService) {
        this.enfermedadCreateService = enfermedadCreateService;
    }

    public void execute(CrearEnfermedadDTO dto) {
        enfermedadCreateService.execute(dto);
    }
}
