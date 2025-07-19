package com.saludsystem.submodules.catalogo.service.medicamento;

import com.saludsystem.submodules.catalogo.mapper.MedicamentoMapper;
import com.saludsystem.submodules.catalogo.model.dto.MedicamentoDTO;
import com.saludsystem.submodules.catalogo.port.dao.MedicamentoDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class MedicamentoAllService {

    private final MedicamentoDao medicamentoDao;

    public MedicamentoAllService(MedicamentoDao medicamentoDao) {
        this.medicamentoDao = medicamentoDao;
    }

    public ListResponse<MedicamentoDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = medicamentoDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
        var data = result.getData().stream().map(MedicamentoMapper::toDto).toList();
        return new ListResponse<>(data, result.getTotalElements(), result.getTotalPages(), result.getCurrentPage());
    }
}
