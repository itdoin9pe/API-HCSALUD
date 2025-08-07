package com.saludsystem.submodules.paciente.command.edit;

import com.saludsystem.submodules.paciente.mapper.MedicamentoRecetadoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.MedicamentoRecetadoEditCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.medicamentorecetado.MedicamentoRecetadoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoRecetadoEditHandler {

    private final MedicamentoRecetadoEditService medicamentoRecetadoEditService;
    private final MedicamentoRecetadoMapper medicamentoRecetadoMapper;

    public MedicamentoRecetadoEditHandler(MedicamentoRecetadoEditService medicamentoRecetadoEditService, MedicamentoRecetadoMapper medicamentoRecetadoMapper) {
        this.medicamentoRecetadoEditService = medicamentoRecetadoEditService;
        this.medicamentoRecetadoMapper = medicamentoRecetadoMapper;
    }

    public void execute(UUID uuid, MedicamentoRecetadoEditCommand editCommand) {

        var medicRecetadoUpdated = medicamentoRecetadoMapper.fromUpdateDto(uuid, editCommand);

        medicamentoRecetadoEditService.execute(uuid, medicRecetadoUpdated);

    }

}
