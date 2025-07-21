package com.saludsystem.submodules.cita.service;

import com.saludsystem.submodules.cita.mapper.CitaMapper;
import com.saludsystem.submodules.cita.model.dtos.get.CitaDTO;
import com.saludsystem.submodules.cita.port.dao.CitaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class CitaAllService {

    private final CitaDao citaDao;

    public CitaAllService(CitaDao citaDao) {
        this.citaDao = citaDao;
    }

    public ListResponse<CitaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = citaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream().map(CitaMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());
    }
}
