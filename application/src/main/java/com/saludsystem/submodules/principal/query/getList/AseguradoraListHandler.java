package com.saludsystem.submodules.principal.query.getList;

import com.saludsystem.submodules.principal.model.dtos.get.AseguradoraDTO;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AseguradoraListHandler {

    private final AseguradoraListService aseguradoraListService;

    public AseguradoraListHandler(AseguradoraListService aseguradoraListService) {
        this.aseguradoraListService = aseguradoraListService;
    }

    public List<AseguradoraDTO> execute() {
        return aseguradoraListService.execute();
    }
}
