package com.saludsystem.submodules.paciente.query.getAll.interconsulta;

import com.saludsystem.submodules.paciente.mapper.interconsulta.InterconsultaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.interconsulta.InterconsultaDTO;
import com.saludsystem.submodules.paciente.port.dao.interconsulta.InterconsultaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class InterconsultaAllHandler {

    private final InterconsultaDao interconsultaDao;
    private final InterconsultaMapper interconsultaMapper;

    public InterconsultaAllHandler(InterconsultaDao interconsultaDao, InterconsultaMapper interconsultaMapper) {
        this.interconsultaDao = interconsultaDao;
        this.interconsultaMapper = interconsultaMapper;
    }

    public ListResponse<InterconsultaDTO>  execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = interconsultaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<InterconsultaDTO> data = result.getData()
                .stream()
                .map(interconsultaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
