package com.saludsystem.submodules.catalogo.service.categoria;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class CategoriaAllService {

    private final CategoriaDao categoriaDao;

    public CategoriaAllService(CategoriaDao categoriaDao) {
        this.categoriaDao = categoriaDao;
    }

    public ListResponse<CategoriaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = categoriaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
        var data = result.getData().stream().map(CategoriaMapper::toDto).toList();
        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }
}
