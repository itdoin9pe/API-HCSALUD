package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.service.medicamento.MedicamentoAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MedicamentoAllHandler {

    private final MedicamentoAllService medicamentoAllService;

    public MedicamentoAllHandler(MedicamentoAllService medicamentoAllService) {
        this.medicamentoAllService = medicamentoAllService;
    }

    public ListResponse<MedicamentoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return medicamentoAllService.execute(hospitalId, paginationRequest);
    }
}