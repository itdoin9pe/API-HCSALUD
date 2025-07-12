package com.saludsystem.application.catalogo.query.getAll;

import com.saludsystem.application.catalogo.dtos.get.EspecialidadDTO;
import com.saludsystem.application.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.domain.catalogo.model.Especialidad;
import com.saludsystem.domain.catalogo.port.in.service.EspecialidadService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EspecialidadAllHandler {
    private final EspecialidadService especialidadService;

    public EspecialidadAllHandler(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public List<EspecialidadDTO> execute(UUID hospitalId, int page, int rows) {
        List<Especialidad> models = especialidadService.getAll(hospitalId, page, rows);
        return models.stream().map(EspecialidadMapper::toDto).toList();
    }
}