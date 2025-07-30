package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.dtos.get.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.service.cuenta.CuentaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CuentaListHandler {

    private final CuentaListService cuentaListService;

    public CuentaListHandler(CuentaListService cuentaListService) {
        this.cuentaListService = cuentaListService;
    }

    public List<CuentaDTO> execute() {
        return cuentaListService.execute();
    }
}
