package com.saludsystem.submodules.paciente.query.getList.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.PlanTratamientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.PlanTratamientoDTO;
import com.saludsystem.submodules.paciente.model.entity.tratamiento.PlanTratamiento;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.PlanTratamientoDao;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PlanTratamientoListHandler {

    private final PlanTratamientoDao planTratamientoDao;
    private final PlanTratamientoMapper planTratamientoMapper;

    public PlanTratamientoListHandler(PlanTratamientoDao planTratamientoDao, PlanTratamientoMapper planTratamientoMapper) {
        this.planTratamientoDao = planTratamientoDao;
        this.planTratamientoMapper = planTratamientoMapper;
    }

    public List<PlanTratamientoDTO> execute() {

        List<PlanTratamiento> planTratamientoList = planTratamientoDao.getList();

        return planTratamientoList.stream()
                .map(planTratamientoMapper::toDto)
                .toList();

    }

}
