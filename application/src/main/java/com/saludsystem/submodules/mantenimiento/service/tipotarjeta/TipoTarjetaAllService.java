package com.saludsystem.submodules.mantenimiento.service.tipotarjeta;

import com.saludsystem.submodules.mantenimiento.mapper.TipoTarjetaMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoTarjetaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoTarjetaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class TipoTarjetaAllService {

    private final TipoTarjetaDao tipoTarjetaDao;

    public TipoTarjetaAllService(TipoTarjetaDao tipoTarjetaDao) {
        this.tipoTarjetaDao = tipoTarjetaDao;
    }

    public ListResponse<TipoTarjetaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = tipoTarjetaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(TipoTarjetaMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }
}
