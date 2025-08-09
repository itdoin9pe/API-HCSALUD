package com.saludsystem.submodules.paciente.query.getAll.evolucion;

import com.saludsystem.submodules.paciente.mapper.evolucion.AltaMedicaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.evolucion.AltaMedicaDTO;
import com.saludsystem.submodules.paciente.port.dao.evolucion.AltaMedicaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AltaMedicaAllHandler {

    private final AltaMedicaDao altaMedicaDao;
    private final AltaMedicaMapper altaMedicaMapper;

    public AltaMedicaAllHandler(AltaMedicaDao altaMedicaDao, AltaMedicaMapper altaMedicaMapper) {
        this.altaMedicaDao = altaMedicaDao;
        this.altaMedicaMapper = altaMedicaMapper;
    }

    public ListResponse<AltaMedicaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = altaMedicaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<AltaMedicaDTO> data = result.getData()
                .stream()
                .map(altaMedicaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
