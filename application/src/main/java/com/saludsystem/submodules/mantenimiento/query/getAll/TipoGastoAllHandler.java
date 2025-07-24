package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipogasto.TipoGastoAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoGastoAllHandler {

    private final TipoGastoAllService tipoGastoAllService;

    public TipoGastoAllHandler(TipoGastoAllService tipoGastoAllService) {
        this.tipoGastoAllService = tipoGastoAllService;
    }

    public ListResponse<TipoGastoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return tipoGastoAllService.execute(hospitalId, paginationRequest);
    }

}
