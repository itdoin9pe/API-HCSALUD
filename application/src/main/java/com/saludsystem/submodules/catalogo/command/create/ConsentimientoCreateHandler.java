package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dtos.post.CrearConsentimientoDTO;
import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.port.in.service.ConsentimientoService;
import org.springframework.stereotype.Component;

@Component
public class ConsentimientoCreateHandler {

    private final ConsentimientoService consentimientoService;

    public ConsentimientoCreateHandler(ConsentimientoService consentimientoService) {
        this.consentimientoService = consentimientoService;
    }

    public void execute(CrearConsentimientoDTO dto){
        consentimientoService.save(ConsentimientoMapper.fromCreateDto(dto));
    }
}
