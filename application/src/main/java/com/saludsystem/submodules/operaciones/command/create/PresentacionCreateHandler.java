package com.saludsystem.submodules.operaciones.command.create;

import com.saludsystem.submodules.operaciones.mapper.PresentacionMapper;
import com.saludsystem.submodules.operaciones.model.dtos.command.PresentacionCreateCommand;
import com.saludsystem.submodules.operaciones.service.presentacion.PresentacionCreateService;
import org.springframework.stereotype.Component;

@Component
public class PresentacionCreateHandler {

    private final PresentacionCreateService presentacionCreateService;
    private final PresentacionMapper presentacionMapper;

    public PresentacionCreateHandler(PresentacionCreateService presentacionCreateService, PresentacionMapper presentacionMapper) {
        this.presentacionCreateService = presentacionCreateService;
        this.presentacionMapper = presentacionMapper;
    }

    public void execute(PresentacionCreateCommand createCommand) {

        var presentacion = presentacionMapper.fromCreateDto(createCommand);

        presentacionCreateService.execute(presentacion);

    }

}
