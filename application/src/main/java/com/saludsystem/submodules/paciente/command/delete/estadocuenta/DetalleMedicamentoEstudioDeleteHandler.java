package com.saludsystem.submodules.paciente.command.delete.estadocuenta;

import com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio.DetalleMedicamentoEstudioDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DetalleMedicamentoEstudioDeleteHandler {

    private final DetalleMedicamentoEstudioDeleteService detalleMedicamentoEstudioDeleteService;

    public DetalleMedicamentoEstudioDeleteHandler(DetalleMedicamentoEstudioDeleteService detalleMedicamentoEstudioDeleteService) {
        this.detalleMedicamentoEstudioDeleteService = detalleMedicamentoEstudioDeleteService;
    }

    public void execute(UUID uuid) {

        detalleMedicamentoEstudioDeleteService.execute(uuid);

    }

}
