package com.saludsystem.paciente.infrastructure.adapters.in.response.HistorialClinico;

import com.saludsystem.paciente.application.dto.get.historialclinico.AntecedenteDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

@Getter
@Setter
public class AntecedenteListResponse {

    @Schema(description = "Lista de antecedentes")
    private List<AntecedenteDTO> data;

    @Schema(description = "Total de registros para antecedentes", example = "0")
    private long totalData;

}