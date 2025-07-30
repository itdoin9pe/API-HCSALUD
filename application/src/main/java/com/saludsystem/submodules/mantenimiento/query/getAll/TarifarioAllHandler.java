package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.dtos.get.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.service.tarifario.TarifarioAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TarifarioAllHandler {

    private final TarifarioAllService tarifarioAllService;

    public TarifarioAllHandler(TarifarioAllService tarifarioAllService) {
        this.tarifarioAllService = tarifarioAllService;
    }

    public ListResponse<TarifarioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return tarifarioAllService.execute(hospitalId, paginationRequest);
    }
}
