package com.saludsystem.submodules.operaciones.query.getAll;

import com.saludsystem.submodules.operaciones.mapper.MarcaMapper;
import com.saludsystem.submodules.operaciones.model.dtos.MarcaDTO;
import com.saludsystem.submodules.operaciones.port.dao.MarcaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MarcaAllHandler {

    private final MarcaDao marcaDao;
    private final MarcaMapper marcaMapper;

    public MarcaAllHandler(MarcaDao marcaDao, MarcaMapper marcaMapper) {
        this.marcaDao = marcaDao;
        this.marcaMapper = marcaMapper;
    }

    public ListResponse<MarcaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = marcaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<MarcaDTO> data = result.getData()
                .stream()
                .map(marcaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
