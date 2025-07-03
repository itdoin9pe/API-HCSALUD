package com.saludsystem.infrastructure.adapters.in.response.paciente.Evolucion;

import com.saludsystem.application.dtos.paciente.get.evolucion.NotaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class NotaResponse {

    @Schema(description = "Lista de registros para notas de evolucion del paciente")
    private List<NotaDTO> data;

    @Schema(description = "Total de registros para notas de evolucion del paciente", example = "0")
    private long totalData;

}