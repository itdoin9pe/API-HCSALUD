package com.saludsystem.submodules.principal.query.getById;

import com.saludsystem.submodules.principal.dtos.get.PaisDTO;
import com.saludsystem.submodules.principal.service.pais.PaisByIdService;
import org.springframework.stereotype.Component;

@Component
public class PaisByIdHandler {

    private final PaisByIdService paisByIdService;

    public PaisByIdHandler(PaisByIdService paisByIdService) {
        this.paisByIdService = paisByIdService;
    }

    public PaisDTO execute(Integer id) {
        return paisByIdService.execute(id);
    }

}
