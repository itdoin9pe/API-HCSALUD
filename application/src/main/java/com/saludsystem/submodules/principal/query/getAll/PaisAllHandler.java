package com.saludsystem.submodules.principal.query.getAll;

import com.saludsystem.submodules.principal.dtos.get.PaisDTO;
import com.saludsystem.submodules.principal.service.pais.PaisAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PaisAllHandler {

    private final PaisAllService paisAllService;

    public PaisAllHandler(PaisAllService paisAllService) {
        this.paisAllService = paisAllService;
    }

    public ListResponse<PaisDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return paisAllService.execute(hospitalId, paginationRequest);
    }

}
