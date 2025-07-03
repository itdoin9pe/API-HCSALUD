package com.saludsystem.infrastructure.adapters.in.response.paciente;

import com.saludsystem.application.dtos.paciente.get.RecetaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class RecetaResponse {

    @Schema(description = "Lista de registros para recetas del paciente")
    private List<RecetaDTO> data;

    @Schema(description = "Total de registros para recetas del paciente", example = "0")
    private long totalData;

}