package com.saludsystem.submodules.paciente.command.delete.interconsulta;

import com.saludsystem.submodules.paciente.service.historia.interconsulta.InterconsultaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InterconsultaDeleteHandler {

    private final InterconsultaDeleteService interconsultaDeleteService;

    public InterconsultaDeleteHandler(InterconsultaDeleteService interconsultaDeleteService) {
        this.interconsultaDeleteService = interconsultaDeleteService;
    }

    public void execute(UUID uuid) {

        interconsultaDeleteService.execute(uuid);

    }

}
