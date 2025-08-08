package com.saludsystem.submodules.paciente.command.delete.estadocuenta;

import com.saludsystem.submodules.paciente.service.historia.estadocuenta.estadopago.EPagoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EPagoDeleteHandler {

    private final EPagoDeleteService ePagoDeleteService;

    public EPagoDeleteHandler(EPagoDeleteService ePagoDeleteService) {
        this.ePagoDeleteService = ePagoDeleteService;
    }

    public void execute(UUID uuid) {

        ePagoDeleteService.execute(uuid);

    }

}
