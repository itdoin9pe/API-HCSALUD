package com.saludsystem.submodules.paciente.response.historialclinico;

import com.saludsystem.submodules.paciente.model.dtos.get.historialclinico.ConsultaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ConsultaListResponse {

    @Schema(description = "Registro de consultas del paciente")
    private List<ConsultaDTO> data;

    @Schema(description = "Registros totales de consultas del paciente", example = "0")
    private long totalData;

}