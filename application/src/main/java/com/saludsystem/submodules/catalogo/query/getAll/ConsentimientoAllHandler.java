package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoCreateCommand;
import com.saludsystem.submodules.catalogo.service.consentimiento.ConsentimientoAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ConsentimientoAllHandler {

    private final ConsentimientoAllService consentimientoAllService;

    public ConsentimientoAllHandler(ConsentimientoAllService consentimientoAllService) {
        this.consentimientoAllService = consentimientoAllService;
    }

    public ListResponse<ConsentimientoCreateCommand> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return consentimientoAllService.execute(hospitalId, paginationRequest);
    }
}