package com.saludSystem.infrastructure.adapters.in.response.Paciente;

import com.saludSystem.application.dtos.Paciente.GET.AnalisisOclusal1DTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class AnalisisOclusal1Response {

    @Schema(description = "Lista 1 de Analisis Oclusal de registros para pacientes")
    private List<AnalisisOclusal1DTO> data;

    @Schema(description = "Total de lista 1 de Analisis Oclusal de registros para pacientes", example = "0")
    private long totalData;

}