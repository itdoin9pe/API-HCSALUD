package com.saludsystem.application.paciente.response.evolucion;

import com.saludsystem.application.dto.get.historialclinico.evolucion.NotaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class NotaListResponse {

    @Schema(description = "Lista de registros para notas de evolucion del paciente")
    private List<NotaDTO> data;

    @Schema(description = "Total de registros para notas de evolucion del paciente", example = "0")
    private long totalData;

}