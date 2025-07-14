package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.dtos.post.CrearEspecialidadDTO;
import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.port.in.service.EspecialidadService;
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