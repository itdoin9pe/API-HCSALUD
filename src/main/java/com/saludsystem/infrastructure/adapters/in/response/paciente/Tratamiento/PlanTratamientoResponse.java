package com.saludsystem.infrastructure.adapters.in.response.paciente.Tratamiento;

import com.saludsystem.application.dtos.paciente.get.historialclinico.tratamiento.PlanTratamientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class PlanTratamientoResponse {

    @Schema(description = "Lista de registros para planes de tratamiento")
    private List<PlanTratamientoDTO> data;

    @Schema(description = "Total de Registros para Planes de tratamiento", example = "0")
    private long totalData;

}