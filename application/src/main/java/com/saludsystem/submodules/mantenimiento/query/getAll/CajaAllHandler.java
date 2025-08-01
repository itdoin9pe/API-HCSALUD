package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.mapper.CajaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.CajaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CajaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CajaAllHandler {

    private final CajaDao cajaDao;
    private final CajaMapper cajaMapper;

    public CajaAllHandler(CajaDao cajaDao, CajaMapper cajaMapper) {
        this.cajaDao = cajaDao;
        this.cajaMapper = cajaMapper;
    }

    public ListResponse<CajaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = cajaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<CajaDTO> data = result.getData()
                .stream()
                .map(cajaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
