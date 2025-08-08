package com.saludsystem.submodules.paciente.command.edit.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.DetalleMedicamentoEstudioMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.estadocuenta.DetalleMedicamentoEstudioEditCommand;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.detallemedicamentoestudio.DetalleMedicamentoEstudioEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class DetalleMedicamentoEstudioEditHandler {

    private final DetalleMedicamentoEstudioEditService detalleMedicamentoEstudioEditService;
    private final DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper;

    public DetalleMedicamentoEstudioEditHandler(DetalleMedicamentoEstudioEditService detalleMedicamentoEstudioEditService, DetalleMedicamentoEstudioMapper detalleMedicamentoEstudioMapper) {
        this.detalleMedicamentoEstudioEditService = detalleMedicamentoEstudioEditService;
        this.detalleMedicamentoEstudioMapper = detalleMedicamentoEstudioMapper;
    }

    public void execute(UUID uuid, DetalleMedicamentoEstudioEditCommand editCommand) {

        var detMedicEstudioUpdated = detalleMedicamentoEstudioMapper.fromUpdateDto(uuid, editCommand);

        detalleMedicamentoEstudioEditService.execute(uuid, detMedicEstudioUpdated);

    }

}
