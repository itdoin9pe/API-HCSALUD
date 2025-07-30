package com.saludsystem.submodules.catalogo.service.consentimiento;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class ConsentimientoAllService {

    private final ConsentimientoDao consentimientoDao;

    public ConsentimientoAllService(ConsentimientoDao consentimientoDao) {
        this.consentimientoDao = consentimientoDao;
    }

    public ListResponse<ConsentimientoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = consentimientoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
        var data = result.getData().stream().map(ConsentimientoMapper::toDto).toList();
        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }

}