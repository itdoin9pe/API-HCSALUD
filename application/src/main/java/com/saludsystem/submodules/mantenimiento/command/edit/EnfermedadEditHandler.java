package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarEnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadEditService;
import org.springframework.stereotype.Component;

@Component
public class EnfermedadEditHandler {

    private final EnfermedadEditService enfermedadEditService;

    public EnfermedadEditHandler(EnfermedadEditService enfermedadEditService) {
        this.enfermedadEditService = enfermedadEditService;
    }

    public void execute(String id, ActualizarEnfermedadDTO dto) {
        enfermedadEditService.execute(id, dto);
    }
}
