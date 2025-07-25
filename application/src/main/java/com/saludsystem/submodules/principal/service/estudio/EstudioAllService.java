package com.saludsystem.submodules.principal.service.estudio;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.model.dtos.get.EstudioDTO;
import com.saludsystem.submodules.principal.port.dao.EstudioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class EstudioAllService {

    private final EstudioDao estudioDao;

    public EstudioAllService(EstudioDao estudioDao) {
        this.estudioDao = estudioDao;
    }

    public ListResponse<EstudioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = estudioDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(EstudioMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }

}
