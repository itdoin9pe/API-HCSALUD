package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.model.dtos.put.ActualizarTipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoPagoEditHandler {

    private final TipoPagoEditService tipoPagoEditService;

    public TipoPagoEditHandler(TipoPagoEditService tipoPagoEditService) {
        this.tipoPagoEditService = tipoPagoEditService;
    }

    public void execute(UUID uuid, ActualizarTipoPagoDTO dto) {
        tipoPagoEditService.execute(uuid, dto);
    }
}
