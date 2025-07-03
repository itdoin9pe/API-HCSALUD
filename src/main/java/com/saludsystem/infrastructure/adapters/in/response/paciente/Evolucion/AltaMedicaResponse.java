package com.saludsystem.infrastructure.adapters.in.response.paciente.Evolucion;

import com.saludsystem.application.dtos.paciente.get.evolucion.AltaMedicaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AltaMedicaResponse {

    @Schema(description = "Lista de registros de altas medicas para el paciente")
    private List<AltaMedicaDTO> data;

    @Schema(description = "Total de registros de altas medicas para el paciente", example = "0")
    private long totalData;

}