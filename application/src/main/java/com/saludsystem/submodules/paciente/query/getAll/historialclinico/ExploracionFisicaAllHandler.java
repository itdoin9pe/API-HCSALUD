package com.saludsystem.submodules.paciente.query.getAll.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.ExploracionFisicaMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ExploracionFisicaDTO;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.ExploracionFisicaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ExploracionFisicaAllHandler {

    private final ExploracionFisicaDao exploracionFisicaDao;
    private final ExploracionFisicaMapper exploracionFisicaMapper;

    public ExploracionFisicaAllHandler(ExploracionFisicaDao exploracionFisicaDao, ExploracionFisicaMapper exploracionFisicaMapper) {
        this.exploracionFisicaDao = exploracionFisicaDao;
        this.exploracionFisicaMapper = exploracionFisicaMapper;
    }

    public ListResponse<ExploracionFisicaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = exploracionFisicaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<ExploracionFisicaDTO> data = result.getData()
                .stream()
                .map(exploracionFisicaMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
