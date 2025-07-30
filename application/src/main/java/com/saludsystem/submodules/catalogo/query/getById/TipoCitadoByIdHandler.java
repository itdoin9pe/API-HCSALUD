package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoByIdService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoByIdHandler {

    private final TipoCitadoByIdService tipoCitadoByIdService;

    public TipoCitadoByIdHandler(TipoCitadoByIdService tipoCitadoByIdService) {
        this.tipoCitadoByIdService = tipoCitadoByIdService;
    }

    public TipoCitadoDTO execute(UUID uuid) {
        return tipoCitadoByIdService.execute(uuid);
    }

}
