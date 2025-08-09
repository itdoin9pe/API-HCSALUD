package com.saludsystem.submodules.paciente.command.edit.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.NotaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.evolucion.NotaEditCommand;
import com.saludsystem.submodules.paciente.service.historia.evolucion.nota.NotaEditService;
import org.springframework.stereotype.Component;

@Component
public class NotaEditHandler {

    private final NotaEditService notaEditService;
    private final NotaMapper notaMapper;

    public NotaEditHandler(NotaEditService notaEditService, NotaMapper notaMapper) {
        this.notaEditService = notaEditService;
        this.notaMapper = notaMapper;
    }

    public void execute(Long id, NotaEditCommand editCommand) {

        var notaUpdated = notaMapper.fromUpdateDto(id, editCommand);

        notaEditService.execute(id, notaUpdated);

    }

}
