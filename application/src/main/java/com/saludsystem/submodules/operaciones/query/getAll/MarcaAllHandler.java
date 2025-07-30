package com.saludsystem.submodules.operaciones.query.getAll;

import com.saludsystem.submodules.operaciones.dtos.query.MarcaDTO;
import com.saludsystem.submodules.operaciones.service.marca.MarcaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MarcaAllHandler {

    private final MarcaAllService marcaAllService;

    public MarcaAllHandler(MarcaAllService marcaAllService) {
        this.marcaAllService = marcaAllService;
    }

    public ListResponse<MarcaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return marcaAllService.execute(hospitalId, paginationRequest);
    }

}
