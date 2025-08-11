package com.saludsystem.submodules.paciente.command.delete.historialclinico;

import com.saludsystem.submodules.paciente.service.historia.historialclinico.exploracionfisica.ExploracionFisicaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ExploracionFisicaDeleteHandler {

    private final ExploracionFisicaDeleteService exploracionFisicaDeleteService;

    public ExploracionFisicaDeleteHandler(ExploracionFisicaDeleteService exploracionFisicaDeleteService) {
        this.exploracionFisicaDeleteService = exploracionFisicaDeleteService;
    }

    public void execute(UUID uuid) {

        exploracionFisicaDeleteService.excute(uuid);

    }

}
