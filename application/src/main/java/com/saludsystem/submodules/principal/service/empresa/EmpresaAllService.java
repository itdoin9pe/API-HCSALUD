package com.saludsystem.submodules.principal.service.empresa;

import com.saludsystem.submodules.principal.mapper.EmpresaMapper;
import com.saludsystem.submodules.principal.dtos.get.EmpresaDTO;
import com.saludsystem.submodules.principal.port.dao.EmpresaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class EmpresaAllService {

    private final EmpresaDao empresaDao;

    public EmpresaAllService(EmpresaDao empresaDao) {
        this.empresaDao = empresaDao;
    }

    public ListResponse<EmpresaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = empresaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(EmpresaMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());

    }
}
