package com.saludsystem.infrastructure.adapters.in.response.paciente;

import com.saludsystem.application.dtos.paciente.get.DiagnosticoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DiagnosticoResponse {

    @Schema(description = "Lista de registros del Diagnostico para pacientes")
    private List<DiagnosticoDTO> data;

    @Schema(description = "Total de registro del Diagnostico para pacientes", example = "0")
    private long totalData;

}