package com.saludsystem.submodules.mantenimiento.command.create;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.command.TipoPagoCreateCommand;
import com.saludsystem.submodules.mantenimiento.service.tipopago.TipoPagoCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoPagoCreateHandler {

    private final TipoPagoCreateService tipoPagoCreateService;
    private final TipoPagoMapper tipoPagoMapper;

    public TipoPagoCreateHandler(TipoPagoCreateService tipoPagoCreateService, TipoPagoMapper tipoPagoMapper) {
        this.tipoPagoCreateService = tipoPagoCreateService;
        this.tipoPagoMapper = tipoPagoMapper;
    }

    public void execute(TipoPagoCreateCommand createCommand) {

        var tipoPago = tipoPagoMapper.fromCreateDto(createCommand);

        tipoPagoCreateService.execute(tipoPago);

    }

}
