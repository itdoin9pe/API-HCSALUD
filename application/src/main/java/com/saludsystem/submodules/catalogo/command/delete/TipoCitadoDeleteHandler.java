package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.port.in.service.TipoCitadoService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoDeleteHandler {

    public final TipoCitadoService tipoCitadoService;

    public TipoCitadoDeleteHandler(TipoCitadoService tipoCitadoService) {
        this.tipoCitadoService = tipoCitadoService;
    }

    public void execute(UUID uuid) {
        tipoCitadoService.delete(uuid);
    }
}