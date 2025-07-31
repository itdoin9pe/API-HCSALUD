package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.mapper.EspecialidadMapper;
import com.saludsystem.submodules.catalogo.model.dto.EspecialidadDTO;
import com.saludsystem.submodules.catalogo.port.dao.EspecialidadDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EspecialidadAllHandler {

    private final EspecialidadDao especialidadDao;
    private final EspecialidadMapper especialidadMapper;

    public EspecialidadAllHandler(EspecialidadDao especialidadDao, EspecialidadMapper especialidadMapper) {
        this.especialidadDao = especialidadDao;
        this.especialidadMapper = especialidadMapper;
    }

    public ListResponse<EspecialidadDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = especialidadDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<EspecialidadDTO> data = result.getData()
                .stream()
                .map(especialidadMapper::toDto)
                .toList();

        return new ListResponse<>(
                data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}