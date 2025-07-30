package com.saludsystem.submodules.principal.service.aseguradora;

import com.saludsystem.submodules.principal.dtos.get.AseguradoraDTO;
import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class AseguradoraAllService {

    private final AseguradoraDao aseguradoraDao;

    public AseguradoraAllService(AseguradoraDao aseguradoraDao) {
        this.aseguradoraDao = aseguradoraDao;
    }

    public ListResponse<AseguradoraDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = aseguradoraDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(AseguradoraMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());

    }

}
