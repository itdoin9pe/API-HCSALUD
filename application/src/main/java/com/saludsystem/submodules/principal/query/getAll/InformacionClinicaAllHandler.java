package com.saludsystem.submodules.principal.query.getAll;

import com.saludsystem.submodules.principal.mapper.InformacionClinicaMapper;
import com.saludsystem.submodules.principal.model.dtos.InformacionClinicaDTO;
import com.saludsystem.submodules.principal.port.dao.InformacionClinicaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InformacionClinicaAllHandler {

    private final InformacionClinicaDao informacionClinicaDao;
    private final InformacionClinicaMapper informacionClinicaMapper;

    public InformacionClinicaAllHandler(InformacionClinicaDao informacionClinicaDao, InformacionClinicaMapper informacionClinicaMapper) {
        this.informacionClinicaDao = informacionClinicaDao;
        this.informacionClinicaMapper = informacionClinicaMapper;
    }

    public ListResponse<InformacionClinicaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = informacionClinicaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<InformacionClinicaDTO> data = result.getData()
                .stream()
                .map(informacionClinicaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
