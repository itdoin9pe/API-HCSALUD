package com.saludsystem.submodules.paciente.query.getAll.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.PacienteAlergiaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.PacienteAlergiaDTO;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.PacienteAlergiaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PacienteAlergiaAllHandler {

    private final PacienteAlergiaDao pacienteAlergiaDao;
    private final PacienteAlergiaMapper pacienteAlergiaMapper;

    public PacienteAlergiaAllHandler(PacienteAlergiaDao pacienteAlergiaDao, PacienteAlergiaMapper pacienteAlergiaMapper) {
        this.pacienteAlergiaDao = pacienteAlergiaDao;
        this.pacienteAlergiaMapper = pacienteAlergiaMapper;
    }

    public ListResponse<PacienteAlergiaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = pacienteAlergiaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<PacienteAlergiaDTO> data = result.getData()
                .stream()
                .map(pacienteAlergiaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
