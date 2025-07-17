package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearAlergiaDTO;
import com.saludsystem.submodules.catalogo.service.alergia.AlergiaCreateService;
import org.springframework.stereotype.Component;

@Component
public class AlergiaCreateHandler {

    private final AlergiaCreateService alergiaCreateService;

    public AlergiaCreateHandler(AlergiaCreateService alergiaCreateService) {
        this.alergiaCreateService = alergiaCreateService;
    }

    public void execute(CrearAlergiaDTO dto) {
        alergiaCreateService.execute(dto);
    }
}