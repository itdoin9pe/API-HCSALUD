package com.saludsystem.submodules.paciente.command.delete.estadocuenta;

import com.saludsystem.submodules.paciente.service.historia.estadocuenta.costohospitalizacion.CostoHospitalizacionDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CostoHospitalizacionDeleteHandler {

    private final CostoHospitalizacionDeleteService costoHospitalizacionDeleteService;

    public CostoHospitalizacionDeleteHandler(CostoHospitalizacionDeleteService costoHospitalizacionDeleteService) {
        this.costoHospitalizacionDeleteService = costoHospitalizacionDeleteService;
    }

    public void execute(UUID uuid) {

        costoHospitalizacionDeleteService.execute(uuid);

    }

}
