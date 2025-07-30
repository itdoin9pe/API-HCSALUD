package com.saludsystem.submodules.catalogo.service.apoderado;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class ApoderadoAllService {

    private final ApoderadoDao apoderadoDao;

    public ApoderadoAllService(ApoderadoDao apoderadoDao) {
        this.apoderadoDao = apoderadoDao;
    }

    public ListResponse<ApoderadoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = apoderadoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
        var data = result.getData().stream().map(ApoderadoMapper::toDto).toList();
        return new ListResponse<>(data, result.getCurrentPage(), result.getTotalPages(), result.getCurrentPage());
    }
}
