package com.saludsystem.submodules.mantenimiento.query.getById;

import com.saludsystem.submodules.mantenimiento.dtos.get.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoPagoByIdHandler {

    private final TipoPagoByIdService tipoPagoByIdService;

    public TipoPagoByIdHandler(TipoPagoByIdService tipoPagoByIdService) {
        this.tipoPagoByIdService = tipoPagoByIdService;
    }

    public TipoPagoDTO execute(UUID uuid) {
        return tipoPagoByIdService.execute(uuid);
    }
}
