package com.saludsystem.submodules.paciente.command.create.tratamiento;

import com.saludsystem.submodules.paciente.mapper.tratamiento.PlanTratamientoMapper;
import com.saludsystem.submodules.paciente.model.dtos.command.create.tratamiento.PlanTratamientoCreateCommand;
import com.saludsystem.submodules.paciente.service.historia.tratamiento.PlanTratamientoCreateService;
import org.springframework.stereotype.Component;

@Component
public class PlanTratamientoCreateHandler {

    private final PlanTratamientoCreateService planTratamientoCreateService;
    private final PlanTratamientoMapper planTratamientoMapper;

    public PlanTratamientoCreateHandler(PlanTratamientoCreateService planTratamientoCreateService, PlanTratamientoMapper planTratamientoMapper) {
        this.planTratamientoCreateService = planTratamientoCreateService;
        this.planTratamientoMapper = planTratamientoMapper;
    }

    public void execute(PlanTratamientoCreateCommand createCommand) {

        var planTratamientoSaved = planTratamientoMapper.fromCreateDto(createCommand);

        planTratamientoCreateService.execute(planTratamientoSaved);

    }

}
