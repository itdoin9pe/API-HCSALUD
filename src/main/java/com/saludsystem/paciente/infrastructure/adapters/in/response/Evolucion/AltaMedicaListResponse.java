package com.saludsystem.paciente.infrastructure.adapters.in.response.Evolucion;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AltaMedicaListResponse {

    @Schema(description = "Lista de registros de altas medicas para el paciente")
    private List<com.saludsystem.paciente.application.dto.res.historialclinico.evolucion.AltaMedicaResponse> data;

    @Schema(description = "Total de registros de altas medicas para el paciente", example = "0")
    private long totalData;

}