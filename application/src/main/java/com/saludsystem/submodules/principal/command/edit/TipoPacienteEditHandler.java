package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.mapper.TipoPacienteMapper;
import com.saludsystem.submodules.principal.model.dtos.edit.TipoPacienteEditCommand;
import com.saludsystem.submodules.principal.service.tipopaciente.TipoPacienteEditService;
import org.springframework.stereotype.Component;

@Component
public class TipoPacienteEditHandler {

    private final TipoPacienteEditService tipoPacienteEditService;
    private final TipoPacienteMapper tipoPacienteMapper;

    public TipoPacienteEditHandler(TipoPacienteEditService tipoPacienteEditService, TipoPacienteMapper tipoPacienteMapper) {
        this.tipoPacienteEditService = tipoPacienteEditService;
        this.tipoPacienteMapper = tipoPacienteMapper;
    }

    public void execute(Long id, TipoPacienteEditCommand editCommand) {

        var tipoPacUpdated = tipoPacienteMapper.fromUpdateDto(id, editCommand);

        tipoPacienteEditService.execute(id, tipoPacUpdated);

    }

}
