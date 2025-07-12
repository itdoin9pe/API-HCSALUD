package com.saludsystem.application.catalogo.command.create;

import com.saludsystem.application.catalogo.dtos.post.CrearEspecialidadDTO;
import com.saludsystem.application.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.domain.catalogo.port.in.service.EspecialidadService;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadCreateHandler {
    private final EspecialidadService especialidadService;

    public EspecialidadCreateHandler(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public void execute(CrearEspecialidadDTO dto) {
        especialidadService.save(EspecialidadMapper.fromCreateDto(dto));
    }
}