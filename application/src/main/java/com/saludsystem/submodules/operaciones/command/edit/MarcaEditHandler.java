package com.saludsystem.submodules.operaciones.command.edit;

import com.saludsystem.submodules.operaciones.dtos.edit.ActualizarMarcaDTO;
import com.saludsystem.submodules.operaciones.service.marca.MarcaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MarcaEditHandler {

    private final MarcaEditService marcaEditService;

    public MarcaEditHandler(MarcaEditService marcaEditService) {
        this.marcaEditService = marcaEditService;
    }

    public void execute(UUID uuid, ActualizarMarcaDTO dto) {
        marcaEditService.execute(uuid, dto);
    }

}
