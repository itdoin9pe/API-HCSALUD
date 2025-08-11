package com.saludsystem.submodules.paciente.query.getAll.historialclinico;

import com.saludsystem.submodules.paciente.mapper.historialclinico.AntecedenteMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.AntecedenteDTO;
import com.saludsystem.submodules.paciente.port.dao.historialclinico.AntecedenteDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class AntecedenteAllHandler {

    private final AntecedenteDao antecedenteDao;
    private final AntecedenteMapper antecedenteMapper;

    public AntecedenteAllHandler(AntecedenteDao antecedenteDao, AntecedenteMapper antecedenteMapper) {
        this.antecedenteDao = antecedenteDao;
        this.antecedenteMapper = antecedenteMapper;
    }

    public ListResponse<AntecedenteDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = antecedenteDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<AntecedenteDTO> data = result.getData()
                .stream()
                .map(antecedenteMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}
