package com.saludsystem.submodules.paciente.command.delete;

import com.saludsystem.submodules.paciente.service.fichaclinica.estudioresultado.EstudioResultadoDeleteService;
import org.springframework.stereotype.Component;

@Component
public class EstudioResultadoDeleteHandler {

    private final EstudioResultadoDeleteService estudioResultadoDeleteService;

    public EstudioResultadoDeleteHandler(EstudioResultadoDeleteService estudioResultadoDeleteService) {
        this.estudioResultadoDeleteService = estudioResultadoDeleteService;
    }

    public void execute(Long id) {

        estudioResultadoDeleteService.execute(id);

    }

}
