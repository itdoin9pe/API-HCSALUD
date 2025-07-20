package com.saludsystem.submodules.catalogo.service.tipoconcepto;

import com.saludsystem.submodules.catalogo.mapper.TipoConceptoMapper;
import com.saludsystem.submodules.catalogo.model.dto.TipoConceptoDTO;
import com.saludsystem.submodules.catalogo.port.dao.TipoConceptoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class TipoConceptoAllService {

    private final TipoConceptoDao tipoConceptoDao;

    public TipoConceptoAllService(TipoConceptoDao tipoConceptoDao) {
        this.tipoConceptoDao = tipoConceptoDao;
    }

    public ListResponse<TipoConceptoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = tipoConceptoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        var data = result.getData().stream()
                .map(TipoConceptoMapper::toDto)
                .toList();

        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }
}
