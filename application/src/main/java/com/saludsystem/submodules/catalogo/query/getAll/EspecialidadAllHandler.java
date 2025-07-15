package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dtos.get.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.Especialidad;
import com.saludsystem.submodules.catalogo.port.in.service.EspecialidadService;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EspecialidadAllHandler {
    private final EspecialidadService especialidadService;

    public EspecialidadAllHandler(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public List<EspecialidadDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        List<Especialidad> models = especialidadService.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
        return models.stream().map(EspecialidadMapper::toDto).toList();
    }
}