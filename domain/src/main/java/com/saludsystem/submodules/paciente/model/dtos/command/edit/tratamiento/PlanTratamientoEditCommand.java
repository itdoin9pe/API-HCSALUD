package com.saludsystem.submodules.paciente.model.dtos.command.edit.tratamiento;

import com.saludsystem.submodules.BaseDTO;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PlanTratamientoEditCommand extends BaseDTO {

    private UUID pacientePlanTratamientoId;

    private UUID pacienteId;

    private UUID doctorId;

    private UUID especialidadId;

    private UUID medidaId;

    private LocalDate fechaInicio;

    private LocalDate fechaFin;
}
