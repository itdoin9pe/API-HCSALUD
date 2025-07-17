package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanByIdHandler {
    private final PlanDao planDao;

    public PlanByIdHandler(PlanDao planDao) {
        this.planDao = planDao;
    }

    public PlanDTO execute(UUID uuid) {
        Plan model = planDao.getById(uuid);
        return PlanMapper.toDto(model);
    }
}
