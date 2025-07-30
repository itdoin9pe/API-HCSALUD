package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.ApoderadoCreateCommand;
import com.saludsystem.submodules.catalogo.service.apoderado.ApoderadoAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class ApoderadoAllHandler {

    private final ApoderadoAllService apoderadoAllService;

    public ApoderadoAllHandler(ApoderadoAllService apoderadoAllService) {
        this.apoderadoAllService = apoderadoAllService;
    }

    public ListResponse<ApoderadoCreateCommand> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return apoderadoAllService.execute(hospitalId, paginationRequest);
    }
}
