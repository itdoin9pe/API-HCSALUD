package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.dtos.get.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoPagoAllHandler {

    private final TipoPagoAllService tipoPagoAllService;

    public TipoPagoAllHandler(TipoPagoAllService tipoPagoAllService) {
        this.tipoPagoAllService = tipoPagoAllService;
    }

    public ListResponse<TipoPagoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return tipoPagoAllService.execute(hospitalId, paginationRequest);
    }
}
