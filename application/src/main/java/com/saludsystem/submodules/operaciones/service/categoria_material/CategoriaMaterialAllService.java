package com.saludsystem.submodules.operaciones.service.categoria_material;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.dtos.query.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class CategoriaMaterialAllService {

    private final CategoriaMaterialDao categoriaMaterialDao;

    public CategoriaMaterialAllService(CategoriaMaterialDao categoriaMaterialDao) {
        this.categoriaMaterialDao = categoriaMaterialDao;
    }

    public ListResponse<CategoriaMatDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = categoriaMaterialDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(CategoriaMaterialMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());

    }

}
