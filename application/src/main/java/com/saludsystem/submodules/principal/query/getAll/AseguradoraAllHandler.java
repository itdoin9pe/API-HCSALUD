package com.saludsystem.submodules.principal.query.getAll;

import com.saludsystem.submodules.principal.mapper.AseguradoraMapper;
import com.saludsystem.submodules.principal.model.dtos.AseguradoraDTO;
import com.saludsystem.submodules.principal.port.dao.AseguradoraDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AseguradoraAllHandler {

    private final AseguradoraDao aseguradoraDao;
    private final AseguradoraMapper aseguradoraMapper;

    public AseguradoraAllHandler(AseguradoraDao aseguradoraDao, AseguradoraMapper aseguradoraMapper) {
        this.aseguradoraDao = aseguradoraDao;
        this.aseguradoraMapper = aseguradoraMapper;
    }

    public ListResponse<AseguradoraDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = aseguradoraDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<AseguradoraDTO> data = result.getData()
                .stream()
                .map(aseguradoraMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
