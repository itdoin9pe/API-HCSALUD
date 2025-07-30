package com.saludsystem.submodules.mantenimiento.service.caja;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.CajaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class CajaAllService {

    private final CajaDao cajaDao;

    public CajaAllService(CajaDao cajaDao) {
        this.cajaDao = cajaDao;
    }

    public ListResponse<CajaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = cajaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData()
                .stream()
                .map(CajaMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());

    }
}
