package com.saludsystem.submodules.catalogo.query.getAll;

import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PlanAllHandler {
    private final PlanDao planDao;

    public PlanAllHandler(PlanDao planDao) {
        this.planDao = planDao;
    }

    public List<PlanDTO> execute(UUID  hospitalId, int page, int rows) {
        List<Plan> models = planDao.getAll(hospitalId, page, rows);
        return models.stream().map(PlanMapper::toDto).toList();
    }
}
