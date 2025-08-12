package com.saludsystem.submodules.paciente.query.getById.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.PlanTratamientoMapper;
import com.saludsystem.submodules.paciente.model.constant.tratamiento.PlanTratamientoConstant;
import com.saludsystem.submodules.paciente.model.dtos.get.tratamiento.PlanTratamientoDTO;
import com.saludsystem.submodules.paciente.port.dao.tratamiento.PlanTratamientoDao;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanTratamientoByIdHandler {

    private final PlanTratamientoDao planTratamientoDao;
    private final PlanTratamientoMapper planTratamientoMapper;

    public PlanTratamientoByIdHandler(PlanTratamientoDao planTratamientoDao, PlanTratamientoMapper planTratamientoMapper) {
        this.planTratamientoDao = planTratamientoDao;
        this.planTratamientoMapper = planTratamientoMapper;
    }

    public PlanTratamientoDTO execute(UUID uuid) {

        var planTratamiento = planTratamientoDao.getById(uuid);

        if (planTratamiento == null) {

            throw new IllegalArgumentException(PlanTratamientoConstant.INVALID_ID);

        }

        return planTratamientoMapper.toDto(planTratamiento);

    }

}
