package com.saludsystem.submodules.cita.command.delete;

import com.saludsystem.submodules.cita.service.CitaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CitaDeleteHandler {

    private final CitaDeleteService citaDeleteService;

    public CitaDeleteHandler(CitaDeleteService citaDeleteService) {
        this.citaDeleteService = citaDeleteService;
    }

    public void execute(UUID uuid) {
        citaDeleteService.execute(uuid);
    }
}
