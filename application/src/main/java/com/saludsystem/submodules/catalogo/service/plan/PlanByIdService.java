package com.saludsystem.submodules.catalogo.service.plan;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;

import java.util.UUID;

public class PlanByIdService {

    private final PlanDao planDao;

    public PlanByIdService(PlanDao planDao) {
        this.planDao = planDao;
    }

    public PlanDTO execute(UUID uuid) {
        return PlanMapper.toDto(planDao.getById(uuid));
    }
}
