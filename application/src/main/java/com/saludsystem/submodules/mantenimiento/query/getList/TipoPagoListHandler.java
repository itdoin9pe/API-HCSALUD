package com.saludsystem.submodules.mantenimiento.query.getList;

import com.saludsystem.submodules.mantenimiento.dtos.get.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoPagoListHandler {

    private final TipoPagoListService tipoPagoListService;

    public TipoPagoListHandler(TipoPagoListService tipoPagoListService) {
        this.tipoPagoListService = tipoPagoListService;
    }

    public List<TipoPagoDTO> execute() {
        return tipoPagoListService.execute();
    }
}
