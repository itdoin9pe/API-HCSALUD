package com.saludsystem.paciente.infrastructure.adapters.in.response.Tratamiento;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CostoTratamientoListResponse {

    @Schema(description = "Lista de los costos para tratamiento del paciente")
    private List<com.saludsystem.paciente.application.dto.res.historialclinico.tratamiento.CostoTratamientoResponse> data;

    @Schema(description = "Total de los costos para tratamiento del paciente", example = "0")
    private long totalData;

}