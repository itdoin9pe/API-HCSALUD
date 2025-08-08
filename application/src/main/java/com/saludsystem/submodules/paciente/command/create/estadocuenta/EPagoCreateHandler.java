package com.saludsystem.submodules.paciente.command.create.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EPagoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.estadocuenta.EPagoCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.estadocuenta.estadopago.EPagoCreateService;
import org.springframework.stereotype.Component;

@Component
public class EPagoCreateHandler {

    private final EPagoCreateService ePagoCreateService;
    private final EPagoMapper ePagoMapper;

    public EPagoCreateHandler(EPagoCreateService ePagoCreateService, EPagoMapper ePagoMapper) {
        this.ePagoCreateService = ePagoCreateService;
        this.ePagoMapper = ePagoMapper;
    }

    public void execute(EPagoCreateCommand createCommand) {

        var ePagoSaved = ePagoMapper.fromCreateDto(createCommand);

        ePagoCreateService.execute(ePagoSaved);

    }

}
