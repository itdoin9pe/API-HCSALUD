package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.EnfermedadCreateCommand;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.EnfermedadEditCommand;
import com.saludsystem.submodules.mantenimiento.service.enfermedad.EnfermedadCreateService;
import org.springframework.stereotype.Component;

@Component
public class EnfermedadCreateHandler {

    private final EnfermedadCreateService enfermedadCreateService;
    private final EnfermedadMapper enfermedadMapper;

    public EnfermedadCreateHandler(EnfermedadCreateService enfermedadCreateService, EnfermedadMapper enfermedadMapper) {
        this.enfermedadCreateService = enfermedadCreateService;
        this.enfermedadMapper = enfermedadMapper;
    }

    public void execute(EnfermedadCreateCommand createCommand) {

        var enfermedad = enfermedadMapper.fromCreateDto(createCommand);

        enfermedadCreateService.execute(enfermedad);

    }

}
