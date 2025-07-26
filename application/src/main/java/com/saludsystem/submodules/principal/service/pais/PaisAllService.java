package com.saludsystem.submodules.principal.service.pais;

import com.saludsystem.submodules.principal.mapper.PaisMapper;
import com.saludsystem.submodules.principal.model.dtos.get.PaisDTO;
import com.saludsystem.submodules.principal.port.dao.PaisDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class PaisAllService {

    private final PaisDao paisDao;

    public PaisAllService(PaisDao paisDao) {
        this.paisDao = paisDao;
    }

    public ListResponse<PaisDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = paisDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(PaisMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }

}
