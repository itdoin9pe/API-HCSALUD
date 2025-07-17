package com.saludsystem.submodules.catalogo.command.edit;

import com.saludsystem.submodules.catalogo.model.dto.edit.ActualizarPlanDTO;
import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanEditHandler {
    private final PlanDao planDao;

    public PlanEditHandler(PlanDao planDao) {
        this.planDao = planDao;
    }

    public void execute(UUID uuid, ActualizarPlanDTO dto) {
        planDao.update(uuid, PlanMapper.fromUpdateDto(uuid, dto));
    }
}
