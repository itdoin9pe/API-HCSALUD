package com.saludsystem.submodules.configuracion.query.getById;

import com.saludsystem.submodules.configuracion.mapper.SedeMapper;
import com.saludsystem.submodules.configuracion.model.dtos.SedeDTO;
import com.saludsystem.submodules.configuracion.port.in.dao.SedeDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SedeAllHandler {

    private final SedeDao sedeDao;
    private final SedeMapper sedeMapper;

    public SedeAllHandler(SedeDao sedeDao, SedeMapper sedeMapper) {
        this.sedeDao = sedeDao;
        this.sedeMapper = sedeMapper;
    }

    public ListResponse<SedeDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = sedeDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<SedeDTO> data = result.getData()
                .stream()
                .map(sedeMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
