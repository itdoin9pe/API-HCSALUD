package com.saludsystem.application.paciente.response.historialclinico;

import com.saludsystem.application.paciente.dtos.get.historialclinico.PacienteAlergiaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class PacienteAlergiaListResponse {

    @Schema(description = "Lista de pacientes con alergias")
    private List<PacienteAlergiaDTO> data;

    @Schema(description = "Total de paciente con alergias", example = "0")
    private long totalData;

}