package com.saludsystem.paciente.infrastructure.adapters.in.response.Evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CambioCondicionListResponse {

    @Schema(description = "Lista de registros para el cambio de condicion em la evolucion del paciente")
    private List<com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.CambioCondicionResponse> data;

    @Schema(description = "Total de registros para el cambio de condicion em la evolucion del paciente", example = "0")
    private long totalData;

}