package com.saludsystem.submodules.paciente.command.delete.tratamiento;

import com.saludsystem.submodules.paciente.service.historia.tratamiento.costotratamiento.CostoTratamientoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CostoTratamientoDeleteHandler {

    private final CostoTratamientoDeleteService costoTratamientoDeleteService;

    public CostoTratamientoDeleteHandler(CostoTratamientoDeleteService costoTratamientoDeleteService) {
        this.costoTratamientoDeleteService = costoTratamientoDeleteService;
    }

    public void execute(UUID uuid) {

        costoTratamientoDeleteService.execute(uuid);

    }

}
