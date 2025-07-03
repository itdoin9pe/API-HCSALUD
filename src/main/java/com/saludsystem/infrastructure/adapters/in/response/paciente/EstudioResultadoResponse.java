package com.saludsystem.infrastructure.adapters.in.response.paciente;

import com.saludsystem.application.dtos.paciente.get.EstudioResultadoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class EstudioResultadoResponse {

    @Schema(description = "Lista de registros sobre resultado medicos de los estudios del paciente")
    private List<EstudioResultadoDTO> data;

    @Schema(description = "Total de todos registros sobre resultado medicos de los estudios del paciente", example = "0")
    private long totalData;

}