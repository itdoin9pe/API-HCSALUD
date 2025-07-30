package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.ConsentimientoCreateCommand;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoCreateService;
import org.springframework.stereotype.Component;

@Component
public class ConsentimientoCreateHandler {

    private final ConsentimientoCreateService consentimientoCreateService;

    public ConsentimientoCreateHandler(ConsentimientoCreateService consentimientoCreateService) {
        this.consentimientoCreateService = consentimientoCreateService;
    }

    public void execute(ConsentimientoCreateCommand dto) {
        consentimientoCreateService.execute(dto);
    }
}
