package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApoderadoListHandler {

    private final ApoderadoListService apoderadoListService;

    public ApoderadoListHandler(ApoderadoListService apoderadoListService) {
        this.apoderadoListService = apoderadoListService;
    }

    public List<ApoderadoDTO> execute() {
        return apoderadoListService.execute();
    }
}
