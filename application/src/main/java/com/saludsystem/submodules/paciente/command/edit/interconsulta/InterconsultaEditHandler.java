package com.saludsystem.submodules.paciente.command.edit.interconsulta;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InterconsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.interconsulta.InterconsultaEditCommand;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.InterconsultaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class InterconsultaEditHandler {

    private final InterconsultaEditService interconsultaEditService;
    private final InterconsultaMapper interconsultaMapper;

    public InterconsultaEditHandler(InterconsultaEditService interconsultaEditService, InterconsultaMapper interconsultaMapper) {
        this.interconsultaEditService = interconsultaEditService;
        this.interconsultaMapper = interconsultaMapper;
    }

    public void execute(UUID uuid, InterconsultaEditCommand editCommand) {

        var interconsultaSaved = interconsultaMapper.fromUpdateDto(uuid, editCommand);

        interconsultaEditService.execute(uuid, interconsultaSaved);

    }

}
