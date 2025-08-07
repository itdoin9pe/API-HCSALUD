package com.saludsystem.submodules.paciente.query.getAll;

import com.saludsystem.submodules.paciente.mapper.EstudioMedicoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.EstudioMedicoDTO;
import com.saludsystem.submodules.paciente.port.dao.EstudioMedicoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EstudioMedicoAllHandler {

    private final EstudioMedicoDao estudioMedicoDao;
    private final EstudioMedicoMapper estudioMedicoMapper;

    public EstudioMedicoAllHandler(EstudioMedicoDao estudioMedicoDao, EstudioMedicoMapper estudioMedicoMapper) {
        this.estudioMedicoDao = estudioMedicoDao;
        this.estudioMedicoMapper = estudioMedicoMapper;
    }

    public ListResponse<EstudioMedicoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = estudioMedicoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<EstudioMedicoDTO> data = result.getData()
                .stream()
                .map(estudioMedicoMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
