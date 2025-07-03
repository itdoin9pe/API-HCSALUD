package com.saludsystem.infrastructure.adapters.in.response.paciente.HistorialClinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.AntecedenteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class AntecedenteResponse {

    @Schema(description = "Lista de antecedentes")
    private List<AntecedenteDTO> data;

    @Schema(description = "Total de registros para antecedentes", example = "0")
    private long totalData;

}