package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.mapper.ApoderadoMapper;
import com.saludsystem.submodules.catalogo.model.dto.ApoderadoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ApoderadoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ApoderadoAllHandler {

    private final ApoderadoDao apoderadoDao;
    private final ApoderadoMapper apoderadoMapper;

    public ApoderadoAllHandler(ApoderadoDao apoderadoDao, ApoderadoMapper apoderadoMapper) {
        this.apoderadoDao = apoderadoDao;
        this.apoderadoMapper = apoderadoMapper;
    }

    public ListResponse<ApoderadoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = apoderadoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<ApoderadoDTO> data = result.getData().stream()
                .map(apoderadoMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
