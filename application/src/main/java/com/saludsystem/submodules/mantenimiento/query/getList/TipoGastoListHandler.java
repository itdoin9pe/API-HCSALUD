package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoGastoListHandler {

    private final TipoGastoListService tipoGastoListService;

    public TipoGastoListHandler(TipoGastoListService tipoGastoListService) {
        this.tipoGastoListService = tipoGastoListService;
    }

    public List<TipoGastoDTO> execute() {
        return tipoGastoListService.execute();
    }

}
