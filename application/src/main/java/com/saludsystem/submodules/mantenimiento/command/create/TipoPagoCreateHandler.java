package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.model.dtos.post.CrearTipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoPagoCreateHandler {

    private final TipoPagoCreateService tipoPagoCreateService;

    public TipoPagoCreateHandler(TipoPagoCreateService tipoPagoCreateService) {
        this.tipoPagoCreateService = tipoPagoCreateService;
    }

    public void execute(CrearTipoPagoDTO dto) {
        tipoPagoCreateService.execute(dto);
    }
}
