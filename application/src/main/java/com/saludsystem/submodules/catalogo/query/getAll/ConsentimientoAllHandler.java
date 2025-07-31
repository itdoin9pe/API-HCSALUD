package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.mapper.ConsentimientoMapper;
import com.saludsystem.submodules.catalogo.model.dto.ConsentimientoDTO;
import com.saludsystem.submodules.catalogo.port.dao.ConsentimientoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ConsentimientoAllHandler {

    private final ConsentimientoDao consentimientoDao;
    private final ConsentimientoMapper consentimientoMapper;

    public ConsentimientoAllHandler(ConsentimientoDao consentimientoDao, ConsentimientoMapper consentimientoMapper) {
        this.consentimientoDao = consentimientoDao;
        this.consentimientoMapper = consentimientoMapper;
    }

    public ListResponse<ConsentimientoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = consentimientoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<ConsentimientoDTO> data = result.getData()
                .stream()
                .map(consentimientoMapper::toDto)
                .toList();

        return new ListResponse<>(data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}