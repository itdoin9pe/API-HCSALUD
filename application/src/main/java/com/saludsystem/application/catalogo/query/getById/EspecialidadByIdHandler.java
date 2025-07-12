package com.saludsystem.application.catalogo.query.getById;

import com.saludsystem.application.catalogo.dtos.get.EspecialidadDTO;
import com.saludsystem.application.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.domain.catalogo.model.Especialidad;
import com.saludsystem.domain.catalogo.port.in.service.EspecialidadService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EspecialidadByIdHandler {
    private final EspecialidadService especialidadService;

    public EspecialidadByIdHandler(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public EspecialidadDTO execute(UUID uuid) {
        Especialidad model = especialidadService.getById(uuid);
        return EspecialidadMapper.toDto(model);
    }
}