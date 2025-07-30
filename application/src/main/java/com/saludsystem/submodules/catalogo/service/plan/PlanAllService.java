package com.saludsystem.submodules.catalogo.service.plan;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import com.saludsystem.submodules.response.ListResponse;
import com.saludsystem.submodules.response.PaginationRequest;

import java.util.UUID;

public class PlanAllService {

    private final PlanDao planDao;

    public PlanAllService(PlanDao planDao) {
        this.planDao = planDao;
    }

    public ListResponse<PlanDTO> execute(UUID hospitalId, PaginationRequest paginationRequest) {
        var result = planDao.getAll(hospitalId, paginationRequest.getPage(), paginationRequest.getRows());
        var data = result.getData().stream().map(PlanMapper::toDto).toList();
        return new ListResponse<>(data, result.getTotalElements(),
                result.getTotalPages(), result.getCurrentPage());
    }
}
