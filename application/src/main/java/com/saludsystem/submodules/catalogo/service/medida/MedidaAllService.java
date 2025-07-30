package com.saludsystem.submodules.catalogo.service.medida;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class MedidaAllService {

    private final MedidaDao medidaDao;

    public MedidaAllService(MedidaDao medidaDao) {
        this.medidaDao = medidaDao;
    }

    public ListResponse<MedidaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = medidaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
        var data = result.getData().stream().map(MedidaMapper::toDto).toList();
        return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
    }
}
