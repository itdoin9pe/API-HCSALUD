package com.saludsystem.submodules.configuracion.query.getById;

import com.saludsystem.submodules.configuracion.mapper.PermisoMapper;
import com.saludsystem.submodules.configuracion.model.dtos.PermisoDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.PermisoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PermisoAllHandler {

    private final PermisoDao permisoDao;
    private final PermisoMapper permisoMapper;

    public PermisoAllHandler(PermisoDao permisoDao, PermisoMapper permisoMapper) {
        this.permisoDao = permisoDao;
        this.permisoMapper = permisoMapper;
    }

    public ListResponse<PermisoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = permisoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<PermisoDTO> data = result.getData()
                .stream()
                .map(permisoMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
