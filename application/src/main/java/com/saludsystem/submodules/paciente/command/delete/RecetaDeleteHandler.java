package com.saludsystem.submodules.paciente.command.delete;

import com.saludsystem.submodules.paciente.service.fichaclinica.receta.RecetaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RecetaDeleteHandler {

    private final RecetaDeleteService recetaDeleteService;

    public RecetaDeleteHandler(RecetaDeleteService recetaDeleteService) {
        this.recetaDeleteService = recetaDeleteService;
    }

    public void execute(UUID uuid) {

        recetaDeleteService.execute(uuid);

    }

}
