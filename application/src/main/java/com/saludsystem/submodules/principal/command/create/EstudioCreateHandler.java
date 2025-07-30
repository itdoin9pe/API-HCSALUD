package com.saludsystem.submodules.principal.command.create;

import com.saludsystem.submodules.principal.dtos.post.CrearEstudioDTO;
import com.saludsystem.submodules.principal.service.estudio.EstudioCreateService;
import org.springframework.stereotype.Component;

@Component
public class EstudioCreateHandler {

    private final EstudioCreateService estudioCreateService;

    public EstudioCreateHandler(EstudioCreateService estudioCreateService) {
        this.estudioCreateService = estudioCreateService;
    }

    public void execute(CrearEstudioDTO dto) {
        estudioCreateService.execute(dto);
    }

}
