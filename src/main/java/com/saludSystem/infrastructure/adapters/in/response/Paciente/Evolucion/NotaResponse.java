package com.saludSystem.infrastructure.adapters.in.response.Paciente.Evolucion;

import com.saludSystem.application.dtos.Paciente.GET.Evolucion.NotaDTO;
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