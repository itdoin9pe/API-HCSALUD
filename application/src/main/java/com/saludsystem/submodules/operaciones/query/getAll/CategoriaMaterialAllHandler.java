package com.saludsystem.submodules.operaciones.query.getAll;

import com.saludsystem.submodules.operaciones.model.dtos.get.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.service.categoria_material.CategoriaMaterialAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaMaterialAllHandler {

    private final CategoriaMaterialAllService categoriaMaterialAllService;

    public CategoriaMaterialAllHandler(CategoriaMaterialAllService categoriaMaterialAllService) {
        this.categoriaMaterialAllService = categoriaMaterialAllService;
    }

    public ListResponse<CategoriaMatDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return categoriaMaterialAllService.execute(hospitalId, paginationRequest);
    }

}
