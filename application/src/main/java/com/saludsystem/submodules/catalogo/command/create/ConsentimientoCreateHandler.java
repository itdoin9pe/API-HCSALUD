package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.ConsentimientoCreateCommand;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoCreateService;
import org.springframework.stereotype.Component;

@Component
public class ConsentimientoCreateHandler {

    private final ConsentimientoCreateService consentimientoCreateService;
    private final ConsentimientoMapper consentimientoMapper;

    public ConsentimientoCreateHandler(ConsentimientoCreateService consentimientoCreateService, ConsentimientoMapper consentimientoMapper) {
        this.consentimientoCreateService = consentimientoCreateService;
        this.consentimientoMapper = consentimientoMapper;
    }

    public void execute(ConsentimientoCreateCommand createCommand) {

        var consentimiento = consentimientoMapper.fromCreateDto(createCommand);

        consentimientoCreateService.execute(consentimiento);

    }

}
