package com.saludsystem.submodules.principal.command.edit;

import com.saludsystem.submodules.principal.model.dtos.put.ActualizarPaisDTO;
import com.saludsystem.submodules.principal.service.pais.PaisEditService;
import org.springframework.stereotype.Component;

@Component
public class PaisEditHandler {

    private final PaisEditService paisEditService;

    public PaisEditHandler(PaisEditService paisEditService) {
        this.paisEditService = paisEditService;
    }

    public void execute(Integer id, ActualizarPaisDTO dto) {
        paisEditService.execute(id, dto);
    }

}
