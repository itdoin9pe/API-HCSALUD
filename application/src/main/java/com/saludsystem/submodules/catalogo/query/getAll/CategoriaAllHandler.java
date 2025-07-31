package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.mapper.CategoriaMapper;
import com.saludsystem.submodules.catalogo.model.dto.CategoriaDTO;
import com.saludsystem.submodules.catalogo.port.dao.CategoriaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoriaAllHandler {

    private final CategoriaDao categoriaDao;
    private final CategoriaMapper categoriaMapper;

    public CategoriaAllHandler(CategoriaDao categoriaDao, CategoriaMapper categoriaMapper) {
        this.categoriaDao = categoriaDao;
        this.categoriaMapper = categoriaMapper;
    }

    public ListResponse<CategoriaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = categoriaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<CategoriaDTO> data = result.getData()
                .stream()
                .map(categoriaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
