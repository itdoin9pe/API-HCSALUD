package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.dtos.get.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.service.moneda.MonedaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MonedaAllHandler {

    private final MonedaAllService monedaAllService;

    public MonedaAllHandler(MonedaAllService monedaAllService) {
        this.monedaAllService = monedaAllService;
    }

    public ListResponse<MonedaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return monedaAllService.execute(hospitalId, paginationRequest);
    }
}
