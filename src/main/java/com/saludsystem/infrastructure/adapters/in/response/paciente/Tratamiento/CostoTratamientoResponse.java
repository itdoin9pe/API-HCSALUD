package com.saludsystem.infrastructure.adapters.in.response.paciente.Tratamiento;

import com.saludsystem.application.dtos.paciente.get.historialclinico.tratamiento.CostoTratamientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CostoTratamientoResponse {

    @Schema(description = "Lista de los costos para tratamiento del paciente")
    private List<CostoTratamientoDTO> data;

    @Schema(description = "Total de los costos para tratamiento del paciente", example = "0")
    private long totalData;

}