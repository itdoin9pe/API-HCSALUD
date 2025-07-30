package com.saludsystem.submodules.operaciones.service.marca;

import com.saludsystem.submodules.operaciones.dtos.query.MarcaDTO;
import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class MarcaAllService {

    private final MarcaDao marcaDao;

    public MarcaAllService(MarcaDao marcaDao) {
        this.marcaDao = marcaDao;
    }

    public ListResponse<MarcaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = marcaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData()
                .stream()
                .map(MarcaMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(),
                result.getCurrentPage());

    }

}
