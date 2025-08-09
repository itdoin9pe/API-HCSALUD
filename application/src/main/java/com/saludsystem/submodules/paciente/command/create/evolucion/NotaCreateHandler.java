package com.saludsystem.submodules.paciente.command.create.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.NotaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.evolucion.NotaCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.evolucion.nota.NotaCreateService;
import org.springframework.stereotype.Component;

@Component
public class NotaCreateHandler {

    private final NotaCreateService notaCreateService;
    private final NotaMapper notaMapper;

    public NotaCreateHandler(NotaCreateService notaCreateService, NotaMapper notaMapper) {
        this.notaCreateService = notaCreateService;
        this.notaMapper = notaMapper;
    }

    public void execute(NotaCreateCommand createCommand) {

        var notaSaved = notaMapper.fromCreateDto(createCommand);

        notaCreateService.execute(notaSaved);

    }

}
