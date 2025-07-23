package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TarifarioListHandler {

    private final TarifarioListService tarifarioListService;

    public TarifarioListHandler(TarifarioListService tarifarioListService) {
        this.tarifarioListService = tarifarioListService;
    }

    public List<TarifarioDTO> execute() {
        return tarifarioListService.execute();
    }
}
