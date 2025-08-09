package com.saludsystem.submodules.paciente.command.delete.evolucion;

import com.saludsystem.submodules.paciente.service.historia.evolucion.EvolucionDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EvolucionDeleteHandler {

    private final EvolucionDeleteService evolucionDeleteService;

    public EvolucionDeleteHandler(EvolucionDeleteService evolucionDeleteService) {
        this.evolucionDeleteService = evolucionDeleteService;
    }

    public void execute(UUID uuid) {

        evolucionDeleteService.execute(uuid);

    }

}
