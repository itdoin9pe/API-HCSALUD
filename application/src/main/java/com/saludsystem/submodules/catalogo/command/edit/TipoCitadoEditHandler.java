package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.dto.edit.ActualizarTipoCitadoDTO;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoEditService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoEditHandler {

    private final TipoCitadoEditService tipoCitadoEditService;

    public TipoCitadoEditHandler(TipoCitadoEditService tipoCitadoEditService) {
        this.tipoCitadoEditService = tipoCitadoEditService;
    }

    public void execute(UUID uuid, ActualizarTipoCitadoDTO dto) {
        tipoCitadoEditService.execute(uuid, dto);
    }
}