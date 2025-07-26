package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.model.dtos.post.CrearPaisDTO;
import com.saludsystem.submodules.principal.service.pais.PaisCreateService;
import org.springframework.stereotype.Component;

@Component
public class PaisCreateHandler {

    private final PaisCreateService paisCreateService;

    public PaisCreateHandler(PaisCreateService paisCreateService) {
        this.paisCreateService = paisCreateService;
    }

    public void execute(CrearPaisDTO dto) {
        paisCreateService.execute(dto);
    }

}
