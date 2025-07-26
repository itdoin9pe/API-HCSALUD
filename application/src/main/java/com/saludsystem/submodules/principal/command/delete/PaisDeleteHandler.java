package com.saludsystem.submodules.principal.command.delete;

import com.saludsystem.submodules.principal.service.pais.PaisDeleteService;
import org.springframework.stereotype.Component;

@Component
public class PaisDeleteHandler {

    private final PaisDeleteService paisDeleteService;

    public PaisDeleteHandler(PaisDeleteService paisDeleteService) {
        this.paisDeleteService = paisDeleteService;
    }

    public void execute(Integer id) {
        paisDeleteService.execute(id);
    }

}
