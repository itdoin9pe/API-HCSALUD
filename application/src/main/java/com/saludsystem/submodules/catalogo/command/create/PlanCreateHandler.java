package com.saludsystem.submodules.catalogo.command.create;

import com.saludsystem.submodules.catalogo.model.dto.command.CrearPlanDTO;
import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import org.springframework.stereotype.Component;

@Component
public class PlanCreateHandler {
    private final PlanDao planDao;

    public PlanCreateHandler(PlanDao planDao) {
        this.planDao = planDao;
    }

    public void execute(CrearPlanDTO dto) {
        planDao.save(PlanMapper.fromCreateDto(dto));
    }
}
