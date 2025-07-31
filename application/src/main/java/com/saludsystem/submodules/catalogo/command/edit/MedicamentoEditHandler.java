package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.MedicamentoEditCommand;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoEditHandler {

    private final MedicamentoEditService medicamentoEditService;
    private final MedicamentoMapper medicamentoMapper;

    public MedicamentoEditHandler(MedicamentoEditService medicamentoEditService, MedicamentoMapper medicamentoMapper) {
        this.medicamentoEditService = medicamentoEditService;
        this.medicamentoMapper = medicamentoMapper;
    }

    public void execute(UUID uuid, MedicamentoEditCommand editCommand) {

        var medicamento = medicamentoMapper.fromUpdateDto(uuid, editCommand);

        medicamentoEditService.execute(uuid, medicamento);

    }

}