package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.model.dto.ApoderadoCreateCommand;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ApoderadoListHandler {

    private final ApoderadoListService apoderadoListService;

    public ApoderadoListHandler(ApoderadoListService apoderadoListService) {
        this.apoderadoListService = apoderadoListService;
    }

    public List<ApoderadoCreateCommand> execute() {
        return apoderadoListService.execute();
    }
}
