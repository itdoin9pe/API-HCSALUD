package com.saludsystem.submodules.principal.query.getAll;

import com.saludsystem.submodules.principal.model.dtos.get.AseguradoraDTO;
import com.saludsystem.submodules.principal.service.aseguradora.AseguradoraAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AseguradoraAllHandler {

    private final AseguradoraAllService aseguradoraAllService;

    public AseguradoraAllHandler(AseguradoraAllService aseguradoraAllService) {
        this.aseguradoraAllService = aseguradoraAllService;
    }

    public ListResponse<AseguradoraDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return aseguradoraAllService.execute(hospitalId, paginationRequest);
    }

}
