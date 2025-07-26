package com.saludsystem.submodules.principal.service.informacionclinica;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.dtos.get.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class InformacionClinicaAllService {

    private final InformacionClinicaDao informacionClinicaDao;

    public InformacionClinicaAllService(InformacionClinicaDao informacionClinicaDao) {
        this.informacionClinicaDao = informacionClinicaDao;
    }

    public ListResponse<InformacionClinicaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = informacionClinicaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(InformacionClinicaMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }

}
