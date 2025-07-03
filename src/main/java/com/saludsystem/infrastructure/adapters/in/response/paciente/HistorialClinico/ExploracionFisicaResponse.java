package com.saludsystem.infrastructure.adapters.in.response.paciente.HistorialClinico;

import com.saludsystem.application.dtos.paciente.get.historialclinico.ExploracionFisicaDTO;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class ExploracionFisicaResponse {

    @Schema(description = "Lista de registros de exploraciones fisicas del paciente")
    private List<ExploracionFisicaDTO> data;

    @Schema(description = "Total de registros de exploraciones fisicas del paciente", example = "0")
    private long totalData;

}