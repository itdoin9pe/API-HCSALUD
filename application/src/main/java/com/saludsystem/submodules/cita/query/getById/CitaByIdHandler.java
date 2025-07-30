package com.saludsystem.submodules.cita.query.getById;

import com.saludsystem.submodules.cita.dtos.get.CitaDTO;
import com.saludsystem.submodules.cita.service.CitaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CitaByIdHandler {

    private final CitaByIdService citaByIdService;

    public CitaByIdHandler(CitaByIdService citaByIdService) {
        this.citaByIdService = citaByIdService;
    }

    public CitaDTO execute(UUID uuid) {

        return citaByIdService.execute(uuid);

    }

}