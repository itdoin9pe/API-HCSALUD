package com.saludsystem.submodules.paciente.command.delete.evolucion;

import com.saludsystem.submodules.paciente.service.historia.evolucion.cambiocondicion.CambioCondicionDeleteService;
import org.springframework.stereotype.Component;

@Component
public class CambioCondicionDeleteHandler {

    private final CambioCondicionDeleteService cambioCondicionDeleteService;

    public CambioCondicionDeleteHandler(CambioCondicionDeleteService cambioCondicionDeleteService) {
        this.cambioCondicionDeleteService = cambioCondicionDeleteService;
    }

    public void execute(Long id) {

        cambioCondicionDeleteService.execute(id);

    }

}
