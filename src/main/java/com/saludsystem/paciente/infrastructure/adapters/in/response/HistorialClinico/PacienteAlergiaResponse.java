package com.saludsystem.paciente.infrastructure.adapters.in.response.HistorialClinico;

import com.saludsystem.paciente.application.dto.res.historialclinico.PacienteAlergiaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PacienteAlergiaResponse {

    @Schema(description = "Lista de pacientes con alergias")
    private List<PacienteAlergiaDTO> data;

    @Schema(description = "Total de paciente con alergias", example = "0")
    private long totalData;

}