package com.saludSystem.infrastructure.adapters.in.response.Paciente.Tratamiento;

import com.saludSystem.application.dtos.Paciente.GET.PlanTratamientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PlanTratamientoResponse {

    @Schema(name = "Lista de registros para planes de tratamiento")
    private List<PlanTratamientoDTO> data;

    @Schema(description = "Total de Registros para Planes de tratamiento", example = "0")
    private long totalData;

}