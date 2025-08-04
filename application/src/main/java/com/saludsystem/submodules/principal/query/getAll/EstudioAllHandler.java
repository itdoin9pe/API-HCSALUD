package com.saludsystem.submodules.principal.query.getAll;

import com.saludsystem.submodules.principal.mapper.EstudioMapper;
import com.saludsystem.submodules.principal.model.dtos.EstudioDTO;
import com.saludsystem.submodules.principal.port.dao.EstudioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EstudioAllHandler {

    private final EstudioDao estudioDao;
    private final EstudioMapper estudioMapper;

    public EstudioAllHandler(EstudioDao estudioDao, EstudioMapper estudioMapper) {
        this.estudioDao = estudioDao;
        this.estudioMapper = estudioMapper;
    }

    public ListResponse<EstudioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = estudioDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<EstudioDTO> data = result.getData()
                .stream()
                .map(estudioMapper::toDto)
                .toList();

        return new ListResponse<>(
                data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
