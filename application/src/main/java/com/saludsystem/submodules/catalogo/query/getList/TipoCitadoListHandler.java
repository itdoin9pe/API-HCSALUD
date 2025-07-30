package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.model.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoListService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoCitadoListHandler {

    private final TipoCitadoListService tipoCitadoListService;

    public TipoCitadoListHandler(TipoCitadoListService tipoCitadoListService) {
        this.tipoCitadoListService = tipoCitadoListService;
    }

    public List<TipoCitadoDTO> execute() {
        return tipoCitadoListService.execute();
    }

}