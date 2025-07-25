package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.model.dtos.put.ActualizarAseguradoraDTO;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraEdiService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AseguradoraEditHandler {

    private final AseguradoraEdiService aseguradoraEdiService;

    public AseguradoraEditHandler(AseguradoraEdiService aseguradoraEdiService) {
        this.aseguradoraEdiService = aseguradoraEdiService;
    }

    public void execute(UUID uuid, ActualizarAseguradoraDTO dto) {
        aseguradoraEdiService.execute(uuid, dto);
    }

}
