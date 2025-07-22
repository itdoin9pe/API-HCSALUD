package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.CajaDTO;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CajaAllHandler {

    private final CajaAllService cajaAllService;

    public CajaAllHandler(CajaAllService cajaAllService) {
        this.cajaAllService = cajaAllService;
    }

    public ListResponse<CajaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return cajaAllService.execute(hospitalId, paginationRequest);
    }
}
