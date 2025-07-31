package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.model.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AlergiaAllHandler {

    private final AlergiaDao alergiaDao;
    private final AlergiaMapper alergiaMapper;

    public AlergiaAllHandler(AlergiaDao alergiaDao, AlergiaMapper alergiaMapper) {
        this.alergiaDao = alergiaDao;
        this.alergiaMapper = alergiaMapper;
    }

    public ListResponse<AlergiaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = alergiaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<AlergiaDTO> data = result.getData().stream()
                .map(alergiaMapper::toDto)
                .toList();

        return new ListResponse<>(
                data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage()
        );

    }
}