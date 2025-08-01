package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.mapper.BancoMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.BancoDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.BancoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BancoAllHandler {

    private final BancoDao bancoDao;
    private final BancoMapper bancoMapper;

    public BancoAllHandler(BancoDao bancoDao, BancoMapper bancoMapper) {
        this.bancoDao = bancoDao;
        this.bancoMapper = bancoMapper;
    }

    public ListResponse<BancoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = bancoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<BancoDTO> data = result.getData().stream()
                .map(bancoMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
