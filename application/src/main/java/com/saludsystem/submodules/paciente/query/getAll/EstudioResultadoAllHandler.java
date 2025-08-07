package com.saludsystem.submodules.paciente.query.getAll;

import com.saludsystem.submodules.paciente.mapper.EstudioResultadoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.EstudioResultadoDTO;
import com.saludsystem.submodules.paciente.port.dao.EstudioResultadoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class EstudioResultadoAllHandler {

    private final EstudioResultadoDao estudioResultadoDao;
    private final EstudioResultadoMapper estudioResultadoMapper;

    public EstudioResultadoAllHandler(EstudioResultadoDao estudioResultadoDao, EstudioResultadoMapper estudioResultadoMapper) {
        this.estudioResultadoDao = estudioResultadoDao;
        this.estudioResultadoMapper = estudioResultadoMapper;
    }

    public ListResponse<EstudioResultadoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = estudioResultadoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<EstudioResultadoDTO> data = result.getData()
                .stream()
                .map(estudioResultadoMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
