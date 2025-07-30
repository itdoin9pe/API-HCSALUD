package com.saludsystem.submodules.catalogo.service.alergia;

import com.saludsystem.submodules.catalogo.mapper.AlergiaMapper;
import com.saludsystem.submodules.catalogo.dto.AlergiaDTO;
import com.saludsystem.submodules.catalogo.port.dao.AlergiaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class AlergiaAllService {
    private final AlergiaDao alergiaDao;

    public AlergiaAllService(AlergiaDao alergiaDao) {
        this.alergiaDao = alergiaDao;
    }

    public ListResponse<AlergiaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = alergiaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(AlergiaMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }
}
