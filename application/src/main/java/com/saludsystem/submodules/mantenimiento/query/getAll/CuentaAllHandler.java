package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.model.dtos.get.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CuentaAllHandler {

    private final CuentaAllService cuentaAllService;

    public CuentaAllHandler(CuentaAllService cuentaAllService) {
        this.cuentaAllService = cuentaAllService;
    }

    public ListResponse<CuentaDTO> execute(UUID uuid, PaginationRequest paginationRequest) {
        return cuentaAllService.execute(uuid, paginationRequest);
    }

}
