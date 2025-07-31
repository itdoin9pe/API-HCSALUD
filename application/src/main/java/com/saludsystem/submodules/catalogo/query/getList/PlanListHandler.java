package com.saludsystem.submodules.catalogo.query.getList;

import com.saludsystem.submodules.catalogo.mapper.PlanMapper;
import com.saludsystem.submodules.catalogo.model.Plan;
import com.saludsystem.submodules.catalogo.model.dto.PlanDTO;
import com.saludsystem.submodules.catalogo.port.dao.PlanDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanListHandler {

    private final PlanDao planDao;
    private final PlanMapper planMapper;

    public PlanListHandler(PlanDao planDao, PlanMapper planMapper) {
        this.planDao = planDao;
        this.planMapper = planMapper;
    }

    public List<PlanDTO> execute() {

        List<Plan> planList = planDao.getList();

        return planList.stream()
                .map(planMapper::toDto)
                .toList();

    }

}
