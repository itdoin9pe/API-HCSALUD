package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.command.edit.ActualizarMedidaDTO;
import com.saludsystem.submodules.catalogo.service.medida.MedidaEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaEditHandler {

    private final MedidaEditService medidaEditService;

    public MedidaEditHandler(MedidaEditService medidaEditService) {
        this.medidaEditService = medidaEditService;
    }

    public void execute(UUID uuid, ActualizarMedidaDTO dto) {
        medidaEditService.execute(uuid, dto);
    }
}
