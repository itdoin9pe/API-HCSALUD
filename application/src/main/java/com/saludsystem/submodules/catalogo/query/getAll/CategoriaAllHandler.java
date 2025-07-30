package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.service.categoria.CategoriaAllService;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CategoriaAllHandler {

    private final CategoriaAllService categoriaAllService;

    public CategoriaAllHandler(CategoriaAllService categoriaAllService) {
        this.categoriaAllService = categoriaAllService;
    }

    public ListResponse<CategoriaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        return categoriaAllService.execute(hospitalId, paginationRequest);
    }
}
