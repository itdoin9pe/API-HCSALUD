package com.saludsystem.submodules.principal.query.getAll;

import com.saludsystem.submodules.principal.model.dtos.get.EstudioDTO;
import com.saludsystem.submodules.principal.service.estudio.EstudioAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EstudioAllHandler {

    private final EstudioAllService estudioAllService;

    public EstudioAllHandler(EstudioAllService estudioAllService) {
        this.estudioAllService = estudioAllService;
    }

    public ListResponse<EstudioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return estudioAllService.execute(hospitalId, paginationRequest);
    }

}
