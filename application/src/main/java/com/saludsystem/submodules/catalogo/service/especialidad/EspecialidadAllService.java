package com.saludsystem.submodules.catalogo.service.especialidad;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.dto.EspecialidadCreateCommand;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class EspecialidadAllService {

    private final EspecialidadDao especialidadDao;

    public EspecialidadAllService(EspecialidadDao especialidadDao) {
        this.especialidadDao = especialidadDao;
    }

    public ListResponse<EspecialidadCreateCommand> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = especialidadDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
        var data = result.getData().stream().map(EspecialidadMapper::toDto).toList();
        return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
    }
}
