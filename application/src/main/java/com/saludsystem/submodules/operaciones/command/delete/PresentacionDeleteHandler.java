package com.saludsystem.submodules.operaciones.command.delete;

import com.saludsystem.submodules.operaciones.service.presentacion.PresentacionDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PresentacionDeleteHandler {

    private final PresentacionDeleteService presentacionDeleteService;

    public PresentacionDeleteHandler(PresentacionDeleteService presentacionDeleteService) {
        this.presentacionDeleteService = presentacionDeleteService;
    }

    public void execute(UUID uuid) {

        presentacionDeleteService.execute(uuid);

    }

}
