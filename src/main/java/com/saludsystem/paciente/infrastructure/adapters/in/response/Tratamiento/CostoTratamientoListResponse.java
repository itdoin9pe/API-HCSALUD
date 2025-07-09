package com.saludsystem.paciente.infrastructure.adapters.in.response.Tratamiento;

import com.saludsystem.paciente.application.dto.get.historialclinico.tratamiento.CostoTratamientoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CostoTratamientoListResponse {

    @Schema(description = "Lista de los costos para tratamiento del paciente")
    private List<CostoTratamientoDTO> data;

    @Schema(description = "Total de los costos para tratamiento del paciente", example = "0")
    private long totalData;

}