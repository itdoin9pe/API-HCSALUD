package com.saludsystem.submodules.paciente.command.edit.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.PlanTratamientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento.PlanTratamientoEditCommand;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.PlanTratamientoEdtiService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class PlanTratamientoEditHandler {

    private final PlanTratamientoEdtiService planTratamientoEdtiService;
    private final PlanTratamientoMapper planTratamientoMapper;

    public PlanTratamientoEditHandler(PlanTratamientoEdtiService planTratamientoEdtiService, PlanTratamientoMapper planTratamientoMapper) {
        this.planTratamientoEdtiService = planTratamientoEdtiService;
        this.planTratamientoMapper = planTratamientoMapper;
    }

    public void execute(UUID uuid, PlanTratamientoEditCommand editCommand) {

        var planTratamientoUpdated = planTratamientoMapper.fromUpdateDto(uuid, editCommand);

        planTratamientoEdtiService.execute(uuid, planTratamientoUpdated);

    }

}
