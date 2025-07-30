package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.service.alergia.AlergiaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AlergiaAllHandler {

    private final AlergiaAllService alergiaAllService;

    public AlergiaAllHandler(AlergiaAllService alergiaAllService) {
        this.alergiaAllService = alergiaAllService;
    }

    public ListResponse<AlergiaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return alergiaAllService.execute(hospitalId, paginationRequest);
    }
}