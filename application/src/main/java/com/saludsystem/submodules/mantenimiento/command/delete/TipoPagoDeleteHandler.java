package com.saludsystem.submodules.mantenimiento.command.delete;

import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoPagoDeleteHandler {

    private final TipoPagoDeleteService tipoPagoDeleteService;

    public TipoPagoDeleteHandler(TipoPagoDeleteService tipoPagoDeleteService) {
        this.tipoPagoDeleteService = tipoPagoDeleteService;
    }

    public void execute(UUID uuid) {
        tipoPagoDeleteService.execute(uuid);
    }
}
