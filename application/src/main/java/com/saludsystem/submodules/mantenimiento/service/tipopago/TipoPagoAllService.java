package com.saludsystem.submodules.mantenimiento.service.tipopago;

import com.saludsystem.submodules.mantenimiento.mapper.TipoPagoMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.TipoPagoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TipoPagoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class TipoPagoAllService {

    private final TipoPagoDao tipoPagoDao;

    public TipoPagoAllService(TipoPagoDao tipoPagoDao) {
        this.tipoPagoDao = tipoPagoDao;
    }

    public ListResponse<TipoPagoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = tipoPagoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(TipoPagoMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());

    }
}
