package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.mapper.CuentaMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.CuentaDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.CuentaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class CuentaAllHandler {

    private final CuentaDao cuentaDao;
    private final CuentaMapper cuentaMapper;

    public CuentaAllHandler(CuentaDao cuentaDao, CuentaMapper cuentaMapper) {
        this.cuentaDao = cuentaDao;
        this.cuentaMapper = cuentaMapper;
    }

    public ListResponse<CuentaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = cuentaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<CuentaDTO> data = result.getData().stream()
                .map(cuentaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
