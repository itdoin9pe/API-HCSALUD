package com.saludsystem.submodules.paciente.query.getAll.estadocuenta;

import com.saludsystem.submodules.paciente.mapper.estadocuenta.EstadoCuentaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.estadocuenta.EstadoCuentaDTO;
import com.saludsystem.submodules.paciente.port.dao.estadocuenta.EstadoCuentaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EstadoCuentaAllHandler {

    private final EstadoCuentaDao estadoCuentaDao;
    private final EstadoCuentaMapper estadoCuentaMapper;

    public EstadoCuentaAllHandler(EstadoCuentaDao estadoCuentaDao, EstadoCuentaMapper estadoCuentaMapper) {
        this.estadoCuentaDao = estadoCuentaDao;
        this.estadoCuentaMapper = estadoCuentaMapper;
    }

    public ListResponse<EstadoCuentaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = estadoCuentaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<EstadoCuentaDTO> data = result.getData()
                .stream()
                .map(estadoCuentaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
