package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoTarjetaListHandler {

    private final TipoTarjetaListService tipoTarjetaListService;

    public TipoTarjetaListHandler(TipoTarjetaListService tipoTarjetaListService) {
        this.tipoTarjetaListService = tipoTarjetaListService;
    }

    public List<TipoTarjetaDTO> execute() {
        return tipoTarjetaListService.execute();
    }
}
