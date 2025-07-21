package com.saludsystem.submodules.cita.command.edit;

import com.saludsystem.submodules.cita.model.dtos.put.ActualizarCitaDTO;
import com.saludsystem.submodules.cita.service.CitaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CitaEditHandler {

    private final CitaEditService citaEditService;

    public CitaEditHandler(CitaEditService citaEditService) {
        this.citaEditService = citaEditService;
    }

    public void execute(UUID uuid, ActualizarCitaDTO dto) {

        citaEditService.execute(uuid, dto);

    }

}
