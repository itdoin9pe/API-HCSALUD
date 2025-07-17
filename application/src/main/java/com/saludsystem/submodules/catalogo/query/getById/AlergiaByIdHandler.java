package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.service.alergia.AlergiaByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaByIdHandler {

    private final AlergiaByIdService alergiaByIdService;

    public AlergiaByIdHandler(AlergiaByIdService alergiaByIdService) {
        this.alergiaByIdService = alergiaByIdService;
    }

    public AlergiaDTO execute(UUID id) {
        return alergiaByIdService.execute(id);
    }
}