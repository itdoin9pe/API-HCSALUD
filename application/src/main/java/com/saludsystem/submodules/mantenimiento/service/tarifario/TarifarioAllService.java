package com.saludsystem.submodules.mantenimiento.service.tarifario;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class TarifarioAllService {

    private final TarifarioDao tarifarioDao;

    public TarifarioAllService(TarifarioDao tarifarioDao) {
        this.tarifarioDao = tarifarioDao;
    }

    public ListResponse<TarifarioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = tarifarioDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData()
                .stream()
                .map(TarifarioMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(),
                result.getCurrentPage());

    }
}
