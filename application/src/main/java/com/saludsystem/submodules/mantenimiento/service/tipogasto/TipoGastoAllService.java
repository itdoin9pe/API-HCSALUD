package com.saludsystem.submodules.mantenimiento.service.tipogasto;

import com.saludsystem.submodules.mantenimiento.mapper.TipoGastoMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoGastoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoGastoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class TipoGastoAllService {

    private final TipoGastoDao tipoGastoDao;

    public TipoGastoAllService(TipoGastoDao tipoGastoDao) {
        this.tipoGastoDao = tipoGastoDao;
    }

    public ListResponse<TipoGastoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = tipoGastoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData()
                .stream()
                .map(TipoGastoMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());

    }
}
