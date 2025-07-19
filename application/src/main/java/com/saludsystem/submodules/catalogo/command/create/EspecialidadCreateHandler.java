package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearEspecialidadDTO;
import com.saludsystem.submodules.catalogo.service.especialidad.EspecialidadCreateService;
import org.springframework.stereotype.Component;

@Component
public class EspecialidadCreateHandler {

    private final EspecialidadCreateService especialidadCreateService;

    public EspecialidadCreateHandler(EspecialidadCreateService especialidadCreateService) {
        this.especialidadCreateService = especialidadCreateService;
    }

    public void execute(CrearEspecialidadDTO dto) {
        especialidadCreateService.execute(dto);
    }
}