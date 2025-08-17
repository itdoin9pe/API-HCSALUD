package com.saludsystem.submodules.paciente.command.delete.interconsulta;

import com.saludsystem.submodules.paciente.service.historia.interconsulta.informeinterconsulta.InformeInterDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InformeInterconsultaDeleteHandler {

    private final InformeInterDeleteService informeInterDeleteService;

    public InformeInterconsultaDeleteHandler(InformeInterDeleteService informeInterDeleteService) {
        this.informeInterDeleteService = informeInterDeleteService;
    }

    public void execute(UUID uuid) {

        informeInterDeleteService.execute(uuid);

    }

}
