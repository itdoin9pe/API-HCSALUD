package com.saludsystem.submodules.movimiento.query.getAll;

import com.saludsystem.submodules.movimiento.mapper.CompraMapper;
import com.saludsystem.submodules.movimiento.model.dtos.CompraDTO;
import com.saludsystem.submodules.movimiento.port.dao.CompraDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CompraAllHandler {

    private final CompraDao compraDao;
    private final CompraMapper compraMapper;

    public CompraAllHandler(CompraDao compraDao, CompraMapper compraMapper) {
        this.compraDao = compraDao;
        this.compraMapper = compraMapper;
    }

    public ListResponse<CompraDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = compraDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<CompraDTO> data = result.getData()
                .stream()
                .map(compraMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
