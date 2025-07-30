package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dto.edit.ActualizarAlergiaDTO;
import com.saludsystem.submodules.catalogo.service.alergia.AlergiaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaEditHandler {

    private final AlergiaEditService alergiaEditService;

    public AlergiaEditHandler(AlergiaEditService alergiaEditService) {
        this.alergiaEditService = alergiaEditService;
    }

    public void execute(UUID uuid, ActualizarAlergiaDTO dto) {
        alergiaEditService.execute(uuid, dto);
    }
}