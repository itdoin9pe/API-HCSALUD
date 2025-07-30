package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.TipoCitadoDTO;
import com.saludsystem.submodules.catalogo.service.tipocitado.TipoCitadoAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TipoCitadoAllHandler {

    private final TipoCitadoAllService tipoCitadoAllService;

    public TipoCitadoAllHandler(TipoCitadoAllService tipoCitadoAllService) {
        this.tipoCitadoAllService = tipoCitadoAllService;
    }

    public ListResponse<TipoCitadoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return tipoCitadoAllService.execute(hospitalId, paginationRequest);
    }
}
