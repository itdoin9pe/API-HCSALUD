package com.saludsystem.submodules.paciente.command.delete.estadocuenta;

import com.saludsystem.submodules.paciente.service.historia.estadocuenta.EstadoCuentaDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstadoCuentaDeleteHandler {

    private final EstadoCuentaDeleteService estadoCuentaDeleteService;

    public EstadoCuentaDeleteHandler(EstadoCuentaDeleteService estadoCuentaDeleteService) {
        this.estadoCuentaDeleteService = estadoCuentaDeleteService;
    }

    public void execute(UUID uuid) {

        estadoCuentaDeleteService.execute(uuid);

    }

}
