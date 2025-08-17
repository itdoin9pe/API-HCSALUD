package com.saludsystem.submodules.paciente.command.create.interconsulta;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InformeInterconsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.interconsulta.InformeInterconsultaCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.interconsulta.informeinterconsulta.InformeInterCreateService;
import org.springframework.stereotype.Component;

@Component
public class InformeInterconsultaCreateHandler {

    private final InformeInterCreateService informeInterCreateService;
    private final InformeInterconsultaMapper informeInterconsultaMapper;

    public InformeInterconsultaCreateHandler(InformeInterCreateService informeInterCreateService, InformeInterconsultaMapper informeInterconsultaMapper) {
        this.informeInterCreateService = informeInterCreateService;
        this.informeInterconsultaMapper = informeInterconsultaMapper;
    }

    public void execute(InformeInterconsultaCreateCommand createCommand) {

        var informeInterSaved = informeInterconsultaMapper.fromCreateDto(createCommand);

        informeInterCreateService.execute(informeInterSaved);

    }

}
