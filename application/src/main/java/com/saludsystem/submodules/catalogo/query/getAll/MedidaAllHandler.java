package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.service.medida.MedidaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedidaAllHandler {

    private final MedidaAllService medidaAllService;

    public MedidaAllHandler(MedidaAllService medidaAllService) {
        this.medidaAllService = medidaAllService;
    }

    public ListResponse<MedidaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return medidaAllService.execute(hospitalId, paginationRequest);
    }

}