package com.saludsystem.submodules.principal.query.getList;

import com.saludsystem.submodules.principal.dtos.get.PaisDTO;
import com.saludsystem.submodules.principal.service.pais.PaisListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PaisListHandler {

    private final PaisListService paisListService;

    public PaisListHandler(PaisListService paisListService) {
        this.paisListService = paisListService;
    }

    public List<PaisDTO> execute() {
        return paisListService.execute();
    }

}
