package com.saludsystem.submodules.mantenimiento.command.edit;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.edit.TipoPagoEditCommand;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoPagoEditHandler {

    private final TipoPagoEditService tipoPagoEditService;
    private final TipoPagoMapper tipoPagoMapper;

    public TipoPagoEditHandler(TipoPagoEditService tipoPagoEditService, TipoPagoMapper tipoPagoMapper) {
        this.tipoPagoEditService = tipoPagoEditService;
        this.tipoPagoMapper = tipoPagoMapper;
    }

    public void execute(UUID uuid, TipoPagoEditCommand editCommand) {

        var tipoPago = tipoPagoMapper.fromUpdateDto(uuid, editCommand);

        tipoPagoEditService.execute(uuid, tipoPago);

    }

}
