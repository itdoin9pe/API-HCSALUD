package com.saludsystem.submodules.principal.query.getList;

import com.saludsystem.submodules.principal.dtos.get.EstudioDTO;
import com.saludsystem.submodules.principal.service.estudio.EstudioListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EstudioListHandler {

    private final EstudioListService estudioListService;

    public EstudioListHandler(EstudioListService estudioListService) {
        this.estudioListService = estudioListService;
    }

    public List<EstudioDTO> execute() {
        return estudioListService.execute();
    }

}
