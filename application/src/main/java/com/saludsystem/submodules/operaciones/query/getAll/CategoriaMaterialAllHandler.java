package com.saludsystem.submodules.operaciones.query.getAll;

import com.saludsystem.submodules.operaciones.mapper.CategoriaMaterialMapper;
import com.saludsystem.submodules.operaciones.model.dtos.CategoriaMatDTO;
import com.saludsystem.submodules.operaciones.port.dao.CategoriaMaterialDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CategoriaMaterialAllHandler {

    private final CategoriaMaterialDao categoriaMaterialDao;
    private final CategoriaMaterialMapper categoriaMaterialMapper;

    public CategoriaMaterialAllHandler(CategoriaMaterialDao categoriaMaterialDao, CategoriaMaterialMapper categoriaMaterialMapper) {
        this.categoriaMaterialDao = categoriaMaterialDao;
        this.categoriaMaterialMapper = categoriaMaterialMapper;
    }

    public ListResponse<CategoriaMatDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = categoriaMaterialDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<CategoriaMatDTO> data = result.getData()
                .stream()
                .map(categoriaMaterialMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
