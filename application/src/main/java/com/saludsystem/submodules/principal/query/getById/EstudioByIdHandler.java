package com.saludsystem.submodules.principal.query.getById;

import com.saludsystem.submodules.principal.dtos.get.EstudioDTO;
import com.saludsystem.submodules.principal.service.estudio.EstudioByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstudioByIdHandler {

    private final EstudioByIdService estudioByIdService;

    public EstudioByIdHandler(EstudioByIdService estudioByIdService) {
        this.estudioByIdService = estudioByIdService;
    }

    public EstudioDTO execute(UUID uuid) {
        return estudioByIdService.execute(uuid);
    }

}
