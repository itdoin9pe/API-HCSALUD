package com.saludsystem.submodules.mantenimiento.service.moneda;

import com.saludsystem.submodules.mantenimiento.mapper.MonedaMapper;
import com.saludsystem.submodules.mantenimiento.dtos.get.MonedaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.MonedaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class MonedaAllService {

    private final MonedaDao monedaDao;

    public MonedaAllService(MonedaDao monedaDao) {
        this.monedaDao = monedaDao;
    }

    public ListResponse<MonedaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = monedaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData()
                .stream()
                .map(MonedaMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }
}
