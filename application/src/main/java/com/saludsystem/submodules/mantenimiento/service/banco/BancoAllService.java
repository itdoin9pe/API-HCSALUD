package com.saludsystem.submodules.mantenimiento.service.banco;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.get.BancoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class BancoAllService {

    private final BancoDao bancoDao;

    public BancoAllService(BancoDao bancoDao) {
        this.bancoDao = bancoDao;
    }

    public ListResponse<BancoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = bancoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(BancoMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }
}
