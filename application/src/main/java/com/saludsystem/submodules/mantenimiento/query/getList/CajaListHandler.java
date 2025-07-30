package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.dtos.get.CajaDTO;
import com.saludsystem.submodules.mantenimiento.service.caja.CajaListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CajaListHandler {

    private final CajaListService cajaListService;

    public CajaListHandler(CajaListService cajaListService) {
        this.cajaListService = cajaListService;
    }

    public List<CajaDTO> execute() {
        return cajaListService.execute();
    }
}
