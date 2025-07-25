package com.saludsystem.submodules.principal.command.delete;

import com.saludsystem.submodules.principal.service.estudio.EstudioDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstudioDeleteHandler {

    private final EstudioDeleteService estudioDeleteService;

    public EstudioDeleteHandler(EstudioDeleteService estudioDeleteService) {
        this.estudioDeleteService = estudioDeleteService;
    }

    public void execute(UUID uuid) {
        estudioDeleteService.execute(uuid);
    }

}
