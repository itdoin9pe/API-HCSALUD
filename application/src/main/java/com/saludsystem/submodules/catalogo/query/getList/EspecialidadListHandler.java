package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.dtos.get.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.port.in.service.EspecialidadService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EspecialidadListHandler {
    private final EspecialidadService especialidadService;

    public EspecialidadListHandler(EspecialidadService especialidadService) {
        this.especialidadService = especialidadService;
    }

    public List<EspecialidadDTO> execute() {
        return especialidadService.getList().stream().map(EspecialidadMapper::toDto).toList();
    }
}
