package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.mapper.MedidaMapper;
import com.saludsystem.submodules.catalogo.model.dto.MedidaDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedidaDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class MedidaAllHandler {

    private final MedidaDao medidaDao;
    private final MedidaMapper medidaMapper;

    public MedidaAllHandler(MedidaDao medidaDao, MedidaMapper medidaMapper) {
        this.medidaDao = medidaDao;
        this.medidaMapper = medidaMapper;
    }

    public ListResponse<MedidaDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {

        var result = medidaDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());

        List<MedidaDTO> data = result.getData()
                .stream()
                .map(medidaMapper::toDto)
                .toList();

        return new ListResponse<>(
                data,
                result.getTotalElements(),
                result.getTotalPages(),
                result.getCurrentPage());

    }

}