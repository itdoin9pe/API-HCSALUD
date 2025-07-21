package com.saludsystem.submodules.cita.command.create;

import com.saludsystem.submodules.cita.model.dtos.post.CrearCitaDTO;
import com.saludsystem.submodules.cita.service.CitaCreateService;
import org.springframework.stereotype.Component;

@Component
public class CitaCreateHandler {

    private final CitaCreateService citaCreateService;

    public CitaCreateHandler(CitaCreateService citaCreateService) {
        this.citaCreateService = citaCreateService;
    }

    public void execute(CrearCitaDTO dto) {

        citaCreateService.execute(dto);

    }

}