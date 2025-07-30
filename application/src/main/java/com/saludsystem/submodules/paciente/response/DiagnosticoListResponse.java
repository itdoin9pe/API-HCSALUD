package com.saludsystem.submodules.paciente.response;

import com.saludsystem.submodules.paciente.dtos.get.DiagnosticoDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class DiagnosticoListResponse {

    @Schema(description = "Lista de registros del Diagnostico para pacientes")
    private List<DiagnosticoDTO> data;

    @Schema(description = "Total de registro del Diagnostico para pacientes", example = "0")
    private long totalData;

}