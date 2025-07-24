package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.service.tipotarjeta.TipoTarjetaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoTarjetaAllHandler {

    private final TipoTarjetaAllService tipoTarjetaAllService;

    public TipoTarjetaAllHandler(TipoTarjetaAllService tipoTarjetaAllService) {
        this.tipoTarjetaAllService = tipoTarjetaAllService;
    }

    public ListResponse<TipoTarjetaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return tipoTarjetaAllService.execute(hospitalId, paginationRequest);
    }
}
