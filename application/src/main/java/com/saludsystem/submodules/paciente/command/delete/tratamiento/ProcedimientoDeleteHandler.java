package com.saludsystem.submodules.paciente.command.delete.tratamiento;

import com.saludsystem.submodules.paciente.service.historia.tratamiento.procedimiento.ProcedimientoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ProcedimientoDeleteHandler {

    private final ProcedimientoDeleteService procedimientoDeleteService;

    public ProcedimientoDeleteHandler(ProcedimientoDeleteService procedimientoDeleteService) {
        this.procedimientoDeleteService = procedimientoDeleteService;
    }

    public void execute(UUID uuid) {

        procedimientoDeleteService.execute(uuid);

    }

}
