package com.saludsystem.submodules.catalogo.command.delete;

import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoDeleteService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoDeleteHandler {

    public final TipoCitadoDeleteService tipoCitadoDeleteService;

    public TipoCitadoDeleteHandler(TipoCitadoDeleteService tipoCitadoDeleteService) {
        this.tipoCitadoDeleteService = tipoCitadoDeleteService;
    }

    public void execute(UUID uuid) {
        tipoCitadoDeleteService.execute(uuid);
    }

}