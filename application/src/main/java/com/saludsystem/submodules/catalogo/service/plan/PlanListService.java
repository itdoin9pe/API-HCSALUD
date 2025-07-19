package com.saludsystem.submodules.catalogo.service.plan;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;

import java.util.List;

public class PlanListService {

    private final PlanDao planDao;

    public PlanListService(PlanDao planDao) {
        this.planDao = planDao;
    }

    public List<PlanDTO> execute() {
        return planDao.getList()
                .stream()
                .map(PlanMapper::toDto)
                .toList();
    }
}