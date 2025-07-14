package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dtos.get.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.in.service.EspecialidadService;
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