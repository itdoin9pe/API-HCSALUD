package com.saludsystem.submodules.paciente.command.edit;

import com.saludsystem.submodules.paciente.mapper.EstudioResultadoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.EstudioResultadoEditCommand;
import com.saludsystem.submodules.paciente.service.fichaclinica.estudioresultado.EstudioResultadoEditService;
import org.springframework.stereotype.Component;

@Component
public class EstudioResultadoEditHandler {

    private final EstudioResultadoEditService estudioResultadoEditService;
    private final EstudioResultadoMapper estudioResultadoMapper;

    public EstudioResultadoEditHandler(EstudioResultadoEditService estudioResultadoEditService, EstudioResultadoMapper estudioResultadoMapper) {
        this.estudioResultadoEditService = estudioResultadoEditService;
        this.estudioResultadoMapper = estudioResultadoMapper;
    }

    public void execute(Long id, EstudioResultadoEditCommand editCommand) {

        var estudioResultadoUpdated = estudioResultadoMapper.fromUpdateDto(id, editCommand);

        estudioResultadoEditService.execute(id, estudioResultadoUpdated);

    }

}
