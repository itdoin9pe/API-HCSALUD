package com.saludsystem.submodules.cita.command;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.model.dtos.command.CitaCreateCommand;
import com.saludsystem.submodules.cita.service.CitaCreateService;
import org.springframework.stereotype.Component;

@Component
public class CitaCreateHandler {

    private final CitaCreateService citaCreateService;
    private final CitaMapper citaMapper;

    public CitaCreateHandler(CitaCreateService citaCreateService, CitaMapper citaMapper) {
        this.citaCreateService = citaCreateService;
        this.citaMapper = citaMapper;
    }

    public void execute(CitaCreateCommand createCommand) {

        var cita = citaMapper.fromCreateDto(createCommand);

        citaCreateService.execute(cita);

    }

}