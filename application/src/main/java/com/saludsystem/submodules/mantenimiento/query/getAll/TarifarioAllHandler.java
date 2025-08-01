package com.saludsystem.submodules.mantenimiento.query.getAll;

import com.saludsystem.submodules.mantenimiento.mapper.TarifarioMapper;
import com.saludsystem.submodules.mantenimiento.model.dtos.TarifarioDTO;
import com.saludsystem.submodules.mantenimiento.port.dao.TarifarioDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class TarifarioAllHandler {

    private final TarifarioDao tarifarioDao;
    private final TarifarioMapper tarifarioMapper;

    public TarifarioAllHandler(TarifarioDao tarifarioDao, TarifarioMapper tarifarioMapper) {
        this.tarifarioDao = tarifarioDao;
        this.tarifarioMapper = tarifarioMapper;
    }

    public ListResponse<TarifarioDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = tarifarioDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<TarifarioDTO> data = result.getData()
                .stream()
                .map(tarifarioMapper::toDto)
                .toList();

        return new ListResponse<>(
                data,
                result.getTotalElements(),
                result.getCurrentPage(),
                result.getCurrentPage());

    }

}
