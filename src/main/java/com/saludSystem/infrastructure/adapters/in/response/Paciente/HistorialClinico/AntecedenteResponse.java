package com.saludSystem.infrastructure.adapters.in.response.Paciente.HistorialClinico;

import com.saludSystem.application.dtos.Paciente.GET.HistorialClinico.AntecedenteDTO;
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