package com.saludsystem.application.catalogo.command.delete;

import com.saludsystem.domain.catalogo.port.in.service.TipoCitadoService;
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