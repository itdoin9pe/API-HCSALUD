package com.saludsystem.submodules.paciente.command.edit.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.AntecedenteMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.historialclinico.AntecedenteEditCommand;
import com.saludsystem.submodules.paciente.service.historia.historialclinico.antecedente.AntecedenteEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AntecedenteEditHandler {

    private final AntecedenteEditService antecedenteEditService;
    private final AntecedenteMapper antecedenteMapper;

    public AntecedenteEditHandler(AntecedenteEditService antecedenteEditService, AntecedenteMapper antecedenteMapper) {
        this.antecedenteEditService = antecedenteEditService;
        this.antecedenteMapper = antecedenteMapper;
    }

    public void execute(UUID uuid, AntecedenteEditCommand editCommand) {

        var antecedenteUpdated = antecedenteMapper.fromUpdateDto(uuid, editCommand);

        antecedenteEditService.execute(uuid, antecedenteUpdated);

    }

}
