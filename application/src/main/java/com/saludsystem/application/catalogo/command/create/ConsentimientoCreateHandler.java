package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearConsentimientoDTO;
import com.saludsystem.application.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.domain.catalogo.port.in.service.ConsentimientoService;
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
