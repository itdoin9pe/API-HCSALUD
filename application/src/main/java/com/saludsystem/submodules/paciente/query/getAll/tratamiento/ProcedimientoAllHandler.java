package com.saludsystem.submodules.paciente.query.getAll.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.ProcedimientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.ProcedimientoDTO;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.ProcedimientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProcedimientoAllHandler {

    private final ProcedimientoDao procedimientoDao;
    private final ProcedimientoMapper procedimientoMapper;

    public ProcedimientoAllHandler(ProcedimientoDao procedimientoDao, ProcedimientoMapper procedimientoMapper) {
        this.procedimientoDao = procedimientoDao;
        this.procedimientoMapper = procedimientoMapper;
    }

    public ListResponse<ProcedimientoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = procedimientoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<ProcedimientoDTO> data = result.getData()
                .stream()
                .map(procedimientoMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
