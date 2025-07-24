package com.saludsystem.submodules.medico.service;

import com.saludsystem.submodules.medico.dtos.DoctorDTO;
import com.saludsystem.submodules.medico.mapper.DoctorMapper;
import com.saludsystem.submodules.medico.port.dao.DoctorDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class DoctorAllService {

    private final DoctorDao doctorDao;

    public DoctorAllService(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }

    public ListResponse<DoctorDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = doctorDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(DoctorMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }
}
