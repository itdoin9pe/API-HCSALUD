package com.saludsystem.submodules.paciente.command.delete;

import com.saludsystem.submodules.paciente.service.fichaclinica.estudiomedico.EstudioMedicoDeleteService;
import org.springframework.stereotype.Component;

@Component
public class EstudioMedicoDeleteHandler {

    private final EstudioMedicoDeleteService estudioMedicoDeleteService;

    public EstudioMedicoDeleteHandler(EstudioMedicoDeleteService estudioMedicoDeleteService) {
        this.estudioMedicoDeleteService = estudioMedicoDeleteService;
    }

    public void execute(Long id) {

        estudioMedicoDeleteService.execute(id);

    }

}
