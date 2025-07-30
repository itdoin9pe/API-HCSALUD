package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearTipoCitadoDTO;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoCreateService;
import org.springframework.stereotype.Component;

@Component
public class TipoCitadoCreateHandler {

    private final TipoCitadoCreateService tipoCitadoCreateService;

    public TipoCitadoCreateHandler(TipoCitadoCreateService tipoCitadoCreateService) {
        this.tipoCitadoCreateService = tipoCitadoCreateService;
    }

    public void execute(CrearTipoCitadoDTO dto) {
        tipoCitadoCreateService.execute(dto);
    }

}
