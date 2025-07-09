package com.saludsystem.paciente.infrastructure.adapters.in.response.Tratamiento;

import com.saludsystem.paciente.application.dto.get.historialclinico.tratamiento.PlanTratamientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter @Setter
public class PlanTratamientoListResponse {

    @Schema(description = "Lista de registros para planes de tratamiento")
    private List<PlanTratamientoDTO> data;

    @Schema(description = "Total de Registros para Planes de tratamiento", example = "0")
    private long totalData;

}