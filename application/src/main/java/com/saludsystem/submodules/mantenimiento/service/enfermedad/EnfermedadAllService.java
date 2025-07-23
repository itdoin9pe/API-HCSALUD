package com.saludsystem.submodules.mantenimiento.service.enfermedad;

import com.saludsystem.submodules.mantenimiento.mapper.EnfermedadMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.EnfermedadDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.EnfermedadDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class EnfermedadAllService {

    private final EnfermedadDao enfermedadDao;

    public EnfermedadAllService(EnfermedadDao enfermedadDao) {
        this.enfermedadDao = enfermedadDao;
    }

    public ListResponse<EnfermedadDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = enfermedadDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(EnfermedadMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());

    }
}
