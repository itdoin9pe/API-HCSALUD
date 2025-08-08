package com.saludsystem.submodules.paciente.query.getAll;

import com.saludsystem.submodules.paciente.mapper.PacienteMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.PacienteDTO;
import com.saludsystem.submodules.paciente.port.dao.PacienteDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PacienteAllHandler {

    private final PacienteDao pacienteDao;
    private final PacienteMapper pacienteMapper;

    public PacienteAllHandler(PacienteDao pacienteDao, PacienteMapper pacienteMapper) {
        this.pacienteDao = pacienteDao;
        this.pacienteMapper = pacienteMapper;
    }

    public ListResponse<PacienteDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = pacienteDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<PacienteDTO> data = result.getData()
                .stream()
                .map(pacienteMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
