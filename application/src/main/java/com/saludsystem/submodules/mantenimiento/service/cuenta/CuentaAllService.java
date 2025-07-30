package com.saludsystem.submodules.mantenimiento.service.cuenta;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class CuentaAllService {

    private final CuentaDao cuentaDao;

    public CuentaAllService(CuentaDao cuentaDao) {
        this.cuentaDao = cuentaDao;
    }

    public ListResponse<CuentaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = cuentaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData()
                .stream()
                .map(CuentaMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());

    }

}
