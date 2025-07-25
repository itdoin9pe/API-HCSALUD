package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.model.dtos.put.ActualizarEstudioDTO;
import com.saludsystem.submodules.principal.service.estudio.EstudioEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstudioEditHandler {

    private final EstudioEditService estudioEditService;

    public EstudioEditHandler(EstudioEditService estudioEditService) {
        this.estudioEditService = estudioEditService;
    }

    public void execute(UUID uuid, ActualizarEstudioDTO dto) {
        estudioEditService.execute(uuid, dto);
    }

}
