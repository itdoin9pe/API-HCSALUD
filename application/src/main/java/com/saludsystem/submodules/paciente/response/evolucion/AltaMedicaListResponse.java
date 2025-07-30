package com.saludsystem.submodules.paciente.response.evolucion;

import com.saludsystem.submodules.paciente.dtos.get.historialclinico.evolucion.AltaMedicaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AltaMedicaListResponse {

    @Schema(description = "Lista de registros de altas medicas para el paciente")
    private List<AltaMedicaDTO> data;

    @Schema(description = "Total de registros de altas medicas para el paciente", example = "0")
    private long totalData;

}