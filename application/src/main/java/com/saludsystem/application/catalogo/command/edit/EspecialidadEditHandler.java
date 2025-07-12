package com.saludsystem.application.catalogo.command.edit;

import com.saludsystem.application.catalogo.dtos.put.ActualizarEspecialidadDTO;
import com.saludsystem.application.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.domain.catalogo.port.in.service.EspecialidadService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadEditHandler {
    private final EspecialidadService especialidadService;

    public EspecialidadEditHandler(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public void execute(UUID uuid, ActualizarEspecialidadDTO dto) {
        especialidadService.update(uuid, EspecialidadMapper.fromUpdateDto(uuid, dto));
    }
}