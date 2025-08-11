package com.saludsystem.submodules.paciente.query.getAll.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ConsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ConsultaDTO;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ConsultaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ConsultaAllHandler {

    private final ConsultaDao consultaDao;
    private final ConsultaMapper consultaMapper;

    public ConsultaAllHandler(ConsultaDao consultaDao, ConsultaMapper consultaMapper) {
        this.consultaDao = consultaDao;
        this.consultaMapper = consultaMapper;
    }

    public ListResponse<ConsultaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = consultaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<ConsultaDTO> data = result.getData()
                .stream()
                .map(consultaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
