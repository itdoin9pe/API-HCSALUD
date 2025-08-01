package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.dto.command.edit.ConsentimientoEditCommand;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoEditHandler {

    private final ConsentimientoEditService consentimientoEditService;
    private final ConsentimientoMapper consentimientoMapper;

    public ConsentimientoEditHandler(ConsentimientoEditService consentimientoEditService, ConsentimientoMapper consentimientoMapper) {
        this.consentimientoEditService = consentimientoEditService;
        this.consentimientoMapper = consentimientoMapper;
    }

    public void execute(UUID uuid, ConsentimientoEditCommand editCommand) {

        var consentimiento = consentimientoMapper.fromUpdateDto(uuid, editCommand);

        consentimientoEditService.execute(uuid, consentimiento);

    }

}
