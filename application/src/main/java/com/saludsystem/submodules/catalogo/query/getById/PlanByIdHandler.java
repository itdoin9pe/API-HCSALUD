package com.saludsystem.submodules.catalogo.query.getById;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.constant.PlanConstant;
import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanByIdHandler {

    private final PlanDao planDao;
    private final PlanMapper planMapper;

    public PlanByIdHandler(PlanDao planDao, PlanMapper planMapper) {
        this.planDao = planDao;
        this.planMapper = planMapper;
    }

    public PlanDTO execute(UUID uuid) {

        var plan = planDao.getById(uuid);

        if (plan == null) {

            throw new IllegalArgumentException(PlanConstant.INVALID_ID);

        }

        return planMapper.toDto(plan);

    }

}